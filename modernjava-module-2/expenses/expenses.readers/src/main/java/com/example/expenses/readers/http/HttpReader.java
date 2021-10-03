package com.example.expenses.readers.http;

import com.example.expenses.readers.Reader;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpReader implements Reader {

    private HttpClient httpClient;

    public HttpReader() {
        this.httpClient = HttpClients.createDefault();
        System.out.println(this.httpClient);
    }
}
