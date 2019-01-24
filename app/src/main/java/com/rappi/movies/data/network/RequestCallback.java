package com.rappi.movies.data.network;

public interface RequestCallback<T>
{

    void onSuccess( T response );

    void onFailed( NetworkException e );

}
