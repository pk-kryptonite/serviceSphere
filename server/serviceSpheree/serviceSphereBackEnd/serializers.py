from django.contrib.auth.models import User
from rest_framework import serializers
from .models import Users, Address, Country, Province

class UserSerializer(serializers.ModelSerializer):
    class Meta:
        model = Users
        fields = ['user_uuid', 'username', 'email', 'name', 'phone_number', 'address']

class AddressSerializer(serializers.ModelSerializer):
    class Meta:
        model = Address
        fields = ['id', 'street_number', 'suburb', 'province', 'country', 'latitude', 'longitude']
        
class CountrySerializer(serializers.ModelSerializer):
    class Meta:
        model = Country
        fields = ['id', 'name']
        

class ProvinceSerializer(serializers.ModelSerializer):
    class Meta:
        model = Province
        fields = ['id', 'name']