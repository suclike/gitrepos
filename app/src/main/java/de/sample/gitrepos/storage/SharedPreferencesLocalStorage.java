package de.sample.gitrepos.storage;

import javax.inject.Inject;

import android.content.SharedPreferences;

import android.support.annotation.NonNull;

public class SharedPreferencesLocalStorage implements SharedStorage {

    private final SharedPreferences sharedPreferences;

    @Inject
    SharedPreferencesLocalStorage(@NonNull final SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public void putString(final String key, final String values) {
        sharedPreferences.edit().putString(key, values).apply();
    }

    @Override
    public void putInt(final String key, final int value) {
        sharedPreferences.edit().putInt(key, value).apply();
    }

    @Override
    public int getInt(final String key, final int defValue) {
        return sharedPreferences.getInt(key, defValue);
    }

    @Override
    public String getString(final String key, final String defValue) {
        return sharedPreferences.getString(key, defValue);
    }
}
