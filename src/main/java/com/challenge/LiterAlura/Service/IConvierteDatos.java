package com.challenge.LiterAlura.Service;

public interface IConvierteDatos {
    <T> T getDataFromJson(String json, Class<T> clase);
}
