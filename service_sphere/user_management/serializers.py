from django.contrib.auth.models import User
from rest_framework import serializers
from .models import Users, Address, Country, Province
from django.contrib.auth.hashers import make_password

class CountrySerializer(serializers.ModelSerializer):
    class Meta:
        model = Country
        fields = ['id', 'name']
        

class ProvinceSerializer(serializers.ModelSerializer):
    class Meta:
        model = Province
        fields = ['id', 'name']
        
class AddressSerializer(serializers.ModelSerializer):
    province = ProvinceSerializer()
    country = CountrySerializer()
    
    class Meta:
        model = Address
        fields = ['id', 'street_number', 'suburb', 'province', 'country', 'latitude', 'longitude']        

class UserSerializer(serializers.ModelSerializer):
    address = AddressSerializer()
    
    class Meta:
        model = Users
        fields = ['user_uuid', 'username', 'email', 'password', 'name', 'phone_number', 'address']
        extra_kwargs = {'password': {'write_only': True}}
        
    def validate_password(self, value: str) -> str:
        """
        Hash value passed by user.
        """
        return make_password(value)
      
