from django.db import models
import uuid




class Country(models.Model):
    class Meta:
        db_table = 'Country'
        
    name = models.CharField(max_length=100)

    def __str__(self):
        return self.name
    
    

class Province(models.Model):
    class Meta:
        db_table = 'Province'
    name = models.CharField(max_length=100)

    def __str__(self):
        return self.name


        
class Address(models.Model):
    class Meta:
        db_table = 'Address'
        
    street_number = models.IntegerField()
    suburb = models.CharField(max_length=100)
    latitude = models.DecimalField(max_digits=10, decimal_places=8, blank=True, null=True)
    longitude = models.DecimalField(max_digits=11, decimal_places=8, blank=True, null=True)
    province = models.ForeignKey(Province, on_delete=models.CASCADE)
    country = models.ForeignKey(Country, on_delete=models.CASCADE)

    def __str__(self):
        return f"{self.street_number} {self.suburb}"
    
  


class Users(models.Model):
    class Meta:
        db_table = 'Users'
    user_uuid = models.UUIDField(primary_key=True, default=uuid.uuid4, editable=False, unique=True)
    username = models.CharField(max_length=50, unique=True)
    email = models.EmailField(max_length=100, unique=True)
    password = models.CharField(max_length=128)  
    name = models.CharField(max_length=100, blank=True, null=True)
    phone_number = models.CharField(max_length=20, blank=True, null=True)
    address = models.ForeignKey(Address, on_delete=models.SET_NULL, null=True)
    

    def __str__(self):
        return self.username
    
    


    
    
    
    
   
  