from django.contrib.auth.models import User
from rest_framework import serializers
from .models import Users
class UserSerializer(serializers.ModelSerializer):
    class Meta:
        model = Users
        fields = ['user_id', 'username', 'email', 'password', 'name', 'phone_number', 'address', 'latitude', 'longitude']


