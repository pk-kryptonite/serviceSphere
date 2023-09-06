from django.urls import path
from .views import get_users_by_id

urlpatterns = [
    # ... other paths ...
    path('user/', get_users_by_id, name= 'get_user_by_id'),
]

