package com.example.config;

<<<<<<< HEAD
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SupabaseProperties {

    // 🔹 Read directly from ENV (no application.properties needed)
    private final String url = System.getenv("SUPABASE_URL");

    // 🔹 Already present in application.properties
=======
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

@Configuration
public class SupabaseProperties {

    @Value("${supabase.url:}")
    private String urlFromProps;

>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
    @Value("${supabase.service-role-key}")
    private String serviceRoleKey;

    public String getUrl() {
<<<<<<< HEAD
        if (url == null || url.isBlank()) {
            throw new IllegalStateException(
                    "SUPABASE_URL environment variable is not set"
=======
        String url = (urlFromProps != null && !urlFromProps.isBlank())
                ? urlFromProps
                : System.getenv("SUPABASE_URL");
        if (url == null || url.isBlank()) {
            throw new IllegalStateException(
                    "supabase.url or SUPABASE_URL environment variable must be set"
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
            );
        }
        return url;
    }

    public String getServiceRoleKey() {
        return serviceRoleKey;
    }

<<<<<<< HEAD
    // 🔍 Optional debug (remove later)
    @PostConstruct
    public void debug() {
        System.out.println("Supabase URL = " + url);
=======
    @PostConstruct
    public void debug() {
        System.out.println("Supabase URL = " + getUrl());
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
        System.out.println("Supabase Service Role Key loaded = "
                + (serviceRoleKey != null));
    }
}
