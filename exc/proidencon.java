public StateStorage createStateStorage(String key) {
    if (key == null || key.isEmpty()) {
        throw new IllegalArgumentException("Key cannot be null or empty.");
    }
    
    // Assuming StateStorage has a caching mechanism to avoid creating multiple instances for the same key
    StateStorage storage = StateStorage.getFromCache(key);
    if (storage == null) {
        storage = new StateStorage(key);
        StateStorage.addToCache(key, storage);
    }
    
    return storage;
}
