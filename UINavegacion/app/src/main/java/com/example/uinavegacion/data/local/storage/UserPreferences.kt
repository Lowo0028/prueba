package com.example.uinavegacion.data.local.storage

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore("user_prefs")

class UserPreferences (private val context: Context){
    //clave para almacenar la información dentro del store
    private val isLoggedInKey = booleanPreferencesKey("is_logged_in")

    //indicar como modificar su valor
    suspend fun setLoggedIn(value: Boolean){
        context.dataStore.edit { prefs ->
                prefs[isLoggedInKey] = value
        }
    }
    //exponer su contenido
    val isLoggedIn: Flow<Boolean> = context.dataStore.data
        .map { prefs ->
            prefs[isLoggedInKey] ?: false

        }

}