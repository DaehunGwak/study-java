module expenses.readers {
    requires org.apache.httpcomponents.httpclient;

    exports com.example.expenses.readers;
    exports com.example.expenses.readers.file;
    exports com.example.expenses.readers.http;
}
