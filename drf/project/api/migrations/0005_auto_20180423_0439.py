# -*- coding: utf-8 -*-
# Generated by Django 1.11.11 on 2018-04-23 04:39
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('api', '0004_invitation_facebook_id'),
    ]

    operations = [
        migrations.AlterField(
            model_name='party',
            name='lat',
            field=models.DecimalField(decimal_places=7, max_digits=10, null=True),
        ),
        migrations.AlterField(
            model_name='party',
            name='lng',
            field=models.DecimalField(decimal_places=7, max_digits=10, null=True),
        ),
    ]