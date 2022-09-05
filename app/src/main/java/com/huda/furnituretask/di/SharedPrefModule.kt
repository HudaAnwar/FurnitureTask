package com.huda.furnituretask.di

import android.content.Context
import android.content.SharedPreferences
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
object SharedPrefModule {

    @Provides
    @ActivityScoped
    fun provideSocialTokenSharedPref(@ActivityContext context: Context): SharedPreferences? {
        return context.getSharedPreferences("tokens",Context.MODE_PRIVATE)
    }

}