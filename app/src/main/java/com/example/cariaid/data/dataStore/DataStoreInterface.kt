package com.example.cariaid.data.dataStore

import androidx.datastore.preferences.core.Preferences

interface DataStoreInterface {
    suspend fun <T> setValue(
        key: Preferences.Key<T>,
        value: T
    )

    suspend fun <T> getValue(
        key: Preferences.Key<T>
    ):T?

}