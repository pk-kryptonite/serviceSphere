from django.contrib.auth.models import User
from rest_framework.response import Response
from .serializers import UserSerializer
from .models import Users, Address, Country, Province
from rest_framework import status
from rest_framework.decorators import api_view 
from django.contrib.auth.hashers import make_password
from .includes.check_password import verify_password

@api_view(['POST'])
def get_user_by_id(request):
    try:
        user_uuid = request.data.get('user_uuid')
        user = Users.objects.select_related('address', 'address__province', 'address__country').get(user_uuid=user_uuid)
        serializer = UserSerializer(user)
        return Response(serializer.data)
    except Users.DoesNotExist:
        return Response({"error": "User not found"}, status=404)
    
@api_view(['POST'])
def verify_user(request):
    user_name = request.data.get('user_name')
    plain_password = request.data.get('password')
    try:
        userName = Users.objects.get(username=user_name)
    except Users.DoesNotExist:
        return Response({'error': 'username or password incorrect'}, status=status.HTTP_404_NOT_FOUND)
    verify = verify_password(plain_password, userName.password)
    if verify == "success":
        serializer = UserSerializer(userName)
        return Response(serializer.data, status=status.HTTP_200_OK)
    else:
        return Response({'error': 'username or password incorrect'}, status=status.HTTP_404_NOT_FOUND)


@api_view(['POST'])
def create_user(request):
    data = request.data
    required_fields = ['username', 'email', 'password', 'name', 'phone_number', 'address']
    if not all(field in data for field in required_fields):
        return Response({'error': 'Missing required fields'}, status=status.HTTP_400_BAD_REQUEST)

    address_fields = ['street_number', 'suburb', 'province', 'country', 'latitude', 'longitude']
    if not all(field in data['address'] for field in address_fields):
        return Response({'error': 'Missing required address fields'}, status=status.HTTP_400_BAD_REQUEST)
    hashed_pw = make_password(data['password'])
    try:
        province_instance, _ = Province.objects.get_or_create(name=data['address']['province'])
        country_instance, _ = Country.objects.get_or_create(name=data['address']['country'])

        address = Address.objects.create(
            street_number=data['address']['street_number'],
            suburb=data['address']['suburb'],
            latitude=data['address']['latitude'],
            longitude=data['address']['longitude'],
            province=province_instance,
            country=country_instance
        )
        user_instance =  Users.objects.create(
            username=data['username'],
            email=data['email'],
            password=hashed_pw,
            name=data['name'],
            phone_number=data['phone_number'],
            address=address
        )
    except Exception as e: 
        return Response({'error': f"Error creating user: {str(e)}"}, status=status.HTTP_400_BAD_REQUEST)

    return Response({'status': 'success', 'uuid': str(user_instance.user_uuid)}, status=status.HTTP_201_CREATED)