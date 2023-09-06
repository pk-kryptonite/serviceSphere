from django.contrib.auth.models import User
from rest_framework.response import Response
from .serializers import UserSerializer
from .models import Users
from rest_framework import status
from rest_framework.decorators import api_view

@api_view(['POST'])
def get_users_by_id(request):
    user_id = request.data.get('user_id')
    try:
        user_instance = Users.objects.get(user_id=user_id)
    except Users.DoesNotExist:
        return Response({'error': 'User not found.'}, status=status.HTTP_404_NOT_FOUND)

    serializer = UserSerializer(user_instance)
    return Response(serializer.data, status=status.HTTP_200_OK)


    # username = request.data.get('username')
    # email = request.data.get('email')
    # password = request.data.get('password')
    # name = request.data.get('name')
    # phone_number = request.data.get('phone_number')
    # addresss = request.data.get('address')
    # latitude = request.data.get('latitute')
    # longititude = request.data.get('longitude')
    