package com.example.amilimetros.data.local.storage

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore("user_prefs")

class UserPreferences(private val context: Context) {
    private val isLoggedInKey = booleanPreferencesKey("is_logged_in")
    private val userIdKey = longPreferencesKey("user_id")
    private val isAdminKey = booleanPreferencesKey("is_admin")

    suspend fun setLoggedIn(value: Boolean) {
        context.dataStore.edit { prefs ->
            prefs[isLoggedInKey] = value
        }
    }

    suspend fun setUserId(id: Long) {
        context.dataStore.edit { prefs ->
            prefs[userIdKey] = id
        }
    }

    suspend fun setIsAdmin(value: Boolean) {
        context.dataStore.edit { prefs ->
            prefs[isAdminKey] = value
        }
    }

    suspend fun logout() {
        context.dataStore.edit { prefs ->
            prefs[isLoggedInKey] = false
            prefs[userIdKey] = 0L
            prefs[isAdminKey] = false
        }
    }

    val isLoggedIn: Flow<Boolean> = context.dataStore.data.map { prefs ->
        prefs[isLoggedInKey] ?: false
    }

    val userId: Flow<Long> = context.dataStore.data.map { prefs ->
        prefs[userIdKey] ?: 0L
    }

    val isAdmin: Flow<Boolean> = context.dataStore.data.map { prefs ->
        prefs[isAdminKey] ?: false
    }
}