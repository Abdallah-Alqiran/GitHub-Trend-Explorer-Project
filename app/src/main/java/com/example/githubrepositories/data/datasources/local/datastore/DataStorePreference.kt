package com.example.githubrepositories.data.datasources.local.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.githubrepositories.data.Constants.Companion.PREFERENCES_IS_FIRST_TIME
import com.example.githubrepositories.data.Constants.Companion.PREFERENCES_NAME
import kotlinx.coroutines.flow.first

class DataStorePreference(private val context: Context) {

    private val isFirstTime = booleanPreferencesKey(PREFERENCES_IS_FIRST_TIME)
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
        name = PREFERENCES_NAME
    )

    suspend fun saveIsFirstTimeEnterApp(isFirstTimeKey: Boolean) {
        context.dataStore.edit { mutablePreferences ->
            mutablePreferences[isFirstTime] = isFirstTimeKey
        }
    }

    suspend fun readIsFirstTimeEnterApp(): Boolean {
        return context.dataStore.data.first()[isFirstTime] ?: true
    }
}