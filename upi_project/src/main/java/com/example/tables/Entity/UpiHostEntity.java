package com.example.tables.Entity;

import javax.persistence.*;

@Entity
@Table(name = "UPI_HOST_SERVER_CONFIG")
public class UpiHostEntity {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "HOST")
    private String host;

    @Column(name = "URL")
    private String url;

    @Column(name = "ENABLE_PROXY")
    private String enableProxy;

    @Column(name = "PROXY_ADDRESS")
    private String proxyAddress;

    @Column(name = "PROXY_PORT")
    private Integer proxyPort;

    @Column(name = "PROTOCOL")
    private String protocol;

    @Column(name = "METHOD")
    private String method;

    @Column(name = "TRUSTSTORE_PATH")
    private String truststorePath;

    @Column(name = "TRUSTSTORE_PASSWORD")
    private String truststorePassword;

    @Column(name = "KEYSTORE_PATH")
    private String keystorePath;

    @Column(name = "KEYSTORE_PASSWORD")
    private String keystorePassword;

    @Column(name = "READ_TIMEOUT")
    private Integer readTimeout;

    @Column(name = "CONNECT_TIMEOUT")
    private Integer connectTimeout;

    @Column(name = "MAX_CONNECTIONS")
    private Integer maxConnections;

    @Column(name = "MAX_PER_ROUTE")
    private Integer maxPerRoute;

    @Column(name = "TLS_VERSION")
    private String tlsVersion;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEnableProxy() {
        return enableProxy;
    }

    public void setEnableProxy(String enableProxy) {
        this.enableProxy = enableProxy;
    }

    public String getProxyAddress() {
        return proxyAddress;
    }

    public void setProxyAddress(String proxyAddress) {
        this.proxyAddress = proxyAddress;
    }

    public Integer getProxyPort() {
        return proxyPort;
    }

    public void setProxyPort(Integer proxyPort) {
        this.proxyPort = proxyPort;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getTruststorePath() {
        return truststorePath;
    }

    public void setTruststorePath(String truststorePath) {
        this.truststorePath = truststorePath;
    }

    public String getTruststorePassword() {
        return truststorePassword;
    }

    public void setTruststorePassword(String truststorePassword) {
        this.truststorePassword = truststorePassword;
    }

    public String getKeystorePath() {
        return keystorePath;
    }

    public void setKeystorePath(String keystorePath) {
        this.keystorePath = keystorePath;
    }

    public String getKeystorePassword() {
        return keystorePassword;
    }

    public void setKeystorePassword(String keystorePassword) {
        this.keystorePassword = keystorePassword;
    }

    public Integer getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(Integer readTimeout) {
        this.readTimeout = readTimeout;
    }

    public Integer getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(Integer connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public Integer getMaxConnections() {
        return maxConnections;
    }

    public void setMaxConnections(Integer maxConnections) {
        this.maxConnections = maxConnections;
    }

    public Integer getMaxPerRoute() {
        return maxPerRoute;
    }

    public void setMaxPerRoute(Integer maxPerRoute) {
        this.maxPerRoute = maxPerRoute;
    }

    public String getTlsVersion() {
        return tlsVersion;
    }

    public void setTlsVersion(String tlsVersion) {
        this.tlsVersion = tlsVersion;
    }
}

