package com.example.cariaid.data.dataStore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.cariaid.utils.Constant
import kotlinx.coroutines.flow.first

//Todo construct using DI
class DataStoreImpl(private val context:Context): DataStoreInterface {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = Constant.PREF_NAME)

    override suspend fun <T> setValue(key: Preferences.Key<T>, value: T) {
        context.dataStore.edit { dataStore->
            dataStore[key] = value
        }
    }

    override suspend fun <T> getValue(key: Preferences.Key<T>): T? {
       return context.dataStore.data.first()[key]
    }
}