from .base import *

DEBUG = False

ALLOWED_HOSTS = [".elasticbeanstalk.com"]
SECRET_KEY = os.environ.get('SECRET_KEY')

SOCIAL_AUTH_FACEBOOK_KEY = os.environ.get('SOCIAL_AUTH_FACEBOOK_KEY')
SOCIAL_AUTH_FACEBOOK_SECRET = os.environ.get('SOCIAL_AUTH_FACEBOOK_SECRET')