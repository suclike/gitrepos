package de.sample.gitrepos.storage;

public interface SharedStorage {
    void putString(String key, String values);

    void putInt(String key, int value);

    int getInt(String key, int defValue);

    String getString(String key, String defValue);
}
