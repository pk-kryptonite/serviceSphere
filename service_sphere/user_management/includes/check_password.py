from django.contrib.auth.hashers import check_password


def verify_password(plain_password, hashedPassword):
    if check_password(plain_password, hashedPassword):
        return "success"
    return "error"