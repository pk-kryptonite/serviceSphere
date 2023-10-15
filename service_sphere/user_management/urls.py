from django.urls import path
from .views import get_user_by_id, create_user, verify_user, update_user

urlpatterns = [
    # ... other paths ...
    path('get_user/<uuid:user_id>/', get_user_by_id, name= 'get_user_by_id'),
    path('create_user', create_user, name= 'create_user'),
    path('login_user', verify_user, name= 'verify_user'),
    path('update_user', update_user, name= 'update_user'),
]