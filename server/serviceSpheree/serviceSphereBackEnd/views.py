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
    user_id = request.data.get('user_uuid')
    try:
        user_instance = Users.objects.get(user_uuid=user_id)
    except Users.DoesNotExist:
        return Response({'error': 'User not found.'}, status=status.HTTP_404_NOT_FOUND)

    serializer = UserSerializer(user_instance)
    return Response(serializer.data, status=status.HTTP_200_OK)

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
    username = request.data.get('username')
    email = request.data.get('email')
    password = request.data.get('password')
    name = request.data.get('name')
    phone_number = request.data.get('phone_number')
    street_number = request.data.get('street_number')
    suburb = request.data.get('suburb')
    province = request.data.get('province')
    country = request.data.get('country')
    latitude = request.data.get('latitude')
    longitude = request.data.get('longitude')
    hashed_pw = make_password(password)
    try:
        province_instance = Province.objects.create(name=province)
        country_instance = Country.objects.create(name=country)
        address =  Address.objects.create(street_number=street_number, suburb=suburb,latitude=latitude ,longitude=longitude, province=province_instance, country=country_instance)
        Users.objects.create(username=username, email=email, password=hashed_pw, name=name, phone_number=phone_number, address=address)
    except:
        return Response({'error': 'cannot save user'}, status=status.HTTP_404_NOT_FOUND)
    return Response({'status': 'success', 'message': 'user successfully created'}, status=status.HTTP_200_OK)
