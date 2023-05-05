package com.indautosoft.naturalgs.data.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.aptivist.training0423compose.domain.IUserRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

private const val PREFERENCES_NAME = "preferences_name"

private val Context.dataStore by preferencesDataStore(name = PREFERENCES_NAME)


class UserRepositoryImp @Inject constructor(
    private val context: Context
) : IUserRepository {

    override suspend fun getUser(key: String): String {
        return try {
            val preferencesKey = stringPreferencesKey(key)
            val preferences = context.dataStore.data.first()
            preferences[preferencesKey] ?: ""
        } catch (e: Exception){
            e.printStackTrace()
            ""
        }
    }

    override suspend fun setUser(key: String, name: String) {
        val preferenceKey = stringPreferencesKey(key)
        context.dataStore.edit { preferences ->
            preferences[preferenceKey] = name

        }
    }
}