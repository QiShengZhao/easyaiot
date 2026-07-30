package com.basiclab.iot.message.util;

/**
 * <pre>
 * 配置管理
 * </pre>
 *
 * @author <a href="https://github.com/rememberber">RememBerBer</a>
 * @since 2017/6/14.
 */
public class ConfigUtil extends ConfigBaseUtil {

    private static ConfigUtil configUtil = new ConfigUtil();

    public static ConfigUtil getInstance() {
        return configUtil;
    }

    private ConfigUtil() {
        super();
    }

    private int msgType;

    private String msgName;

    private String memberSql;

    private String memberFilePath;

    private int infinityThreadCount;

    private int threadCount;

    private boolean dryRun;

    private boolean radioPerDay;

    private String textPerDay;

    private boolean radioPerWeek;

    private String textPerWeekWeek;

    private String textPerWeekTime;

    private boolean radioCron;

    private String textCron;

    private boolean needReimport;

    private String reimportWay;

    private boolean sendPushResult;

    private String mailResultTos;

    private boolean autoCheckUpdate;

    private boolean useTray;

    private boolean closeToTray;

    private boolean defaultMaxWindow;

    private Integer maxThreads;

    private long pushTotal;

    private String beforeVersion;

    private String wechatMpName;

    private String wechatAppId;

    private String wechatAppSecret;

    private String wechatToken;

    private String wechatAesKey;

    private boolean mpUseProxy;

    private String mpProxyHost;

    private String mpProxyPort;

    private String mpProxyUserName;

    private String mpProxyPassword;

    private boolean mpUseOutSideAt;

    private boolean mpManualAt;

    private boolean mpApiAt;

    private String mpAt;

    private String mpAtExpiresIn;

    private String mpAtApiUrl;

    private String miniAppName;

    private String miniAppAppId;

    private String miniAppAppSecret;

    private String miniAppToken;

    private String miniAppAesKey;

    private boolean maUseProxy;

    private String maProxyHost;

    private String maProxyPort;

    private String maProxyUserName;

    private String maProxyPassword;

    /**
     * 企业微信企业id
     */
    private String wxCpCorpId;

    private String aliyunAccessKeyId;

    private String aliyunAccessKeySecret;

    private String aliyunSign;

    private String aliServerUrl;

    private String aliAppKey;

    private String aliAppSecret;

    private String aliSign;

    private String txyunAppId;

    private String txyunAppKey;

    private String txyunSign;

    private String hwAppKey;
    private String hwAppSecretPassword;
    private String hwAccessUrl;
    private String hwSignature;
    private String hwSenderCode;

    private String bdSecretAccessKey;
    private String bdAccessKeyId;
    private String bdEndPoint;
    private String bdInvokeId;

    private String upAuthorizationToken;

    private String qiniuAccessKey;
    private String qiniuSecretKey;

    private String yunpianApiKey;

    private boolean httpUseProxy;

    private String httpProxyHost;

    private String httpProxyPort;

    private String httpProxyUserName;

    private String httpProxyPassword;

    private String mailHost;

    private String mailPort;

    private String mailFrom;

    private String mailUser;

    private String mailPassword;

    private boolean mailUseStartTLS;

    private boolean mailUseSSL;

    private String mysqlUrl;

    private String mysqlDatabase;

    private String mysqlUser;

    private String mysqlPassword;

    private String theme;

    private String font;

    private int fontSize;

    /**
     * 当前所选的微信账户的id
     */
    private Integer wxAccountId;

    public int getMsgType() {
        return setting.getInt("msgType", "msg", 13);
    }

    public void setMsgType(int msgType) {
        setting.setByGroup("msgType", String.valueOf(msgType), "msg");
    }

    public String getMsgName() {
        return setting.getStr("msgName", "msg", "");
    }

    public void setMsgName(String msgName) {
        setting.setByGroup("msgName", msgName, "msg");
    }

    public String getMemberSql() {
        return setting.getStr("sql", "member", "");
    }

    public void setMemberSql(String memberSql) {
        setting.setByGroup("sql", memberSql, "member");
    }

    public String getMemberFilePath() {
        return setting.getStr("filePath", "member", "");
    }

    public void setMemberFilePath(String memberFilePath) {
        setting.setByGroup("filePath", memberFilePath, "member");
    }

    public int getInfinityThreadCount() {
        return setting.getInt("infinityThreadCount", "push", 20);
    }

    public void setInfinityThreadCount(int infinityThreadCount) {
        setting.setByGroup("infinityThreadCount", String.valueOf(infinityThreadCount), "push");
    }

    public int getThreadCount() {
        return setting.getInt("threadCount", "push", 60);
    }

    public void setThreadCount(int threadCount) {
        setting.setByGroup("threadCount", String.valueOf(threadCount), "push");
    }

    public boolean isDryRun() {
        return setting.getBool("dryRun", "push", true);
    }

    public void setDryRun(boolean dryRun) {
        setting.setByGroup("dryRun", String.valueOf(dryRun), "push");
    }

    public boolean isRadioStartAt() {
        return setting.getBool("radioStartAt", "schedule", false);
    }

    public void setRadioStartAt(boolean radioStartAt) {
        setting.setByGroup("radioStartAt", String.valueOf(radioStartAt), "schedule");
    }

    public String getTextStartAt() {
        return setting.getStr("textStartAt", "schedule", "");
    }

    public void setTextStartAt(String textStartAt) {
        setting.setByGroup("textStartAt", textStartAt, "schedule");
    }

    public boolean isRadioPerDay() {
        return setting.getBool("radioPerDay", "schedule", false);
    }

    public void setRadioPerDay(boolean radioPerDay) {
        setting.setByGroup("radioPerDay", String.valueOf(radioPerDay), "schedule");
    }

    public String getTextPerDay() {
        return setting.getStr("textPerDay", "schedule", "");
    }

    public void setTextPerDay(String textPerDay) {
        setting.setByGroup("textPerDay", textPerDay, "schedule");
    }

    public boolean isRadioPerWeek() {
        return setting.getBool("radioPerWeek", "schedule", false);
    }

    public void setRadioPerWeek(boolean radioPerWeek) {
        setting.setByGroup("radioPerWeek", String.valueOf(radioPerWeek), "schedule");
    }

    public String getTextPerWeekWeek() {
        return setting.getStr("textPerWeek.week", "schedule", "一");
    }

    public void setTextPerWeekWeek(String textPerWeekWeek) {
        setting.setByGroup("textPerWeek.week", textPerWeekWeek, "schedule");
    }

    public String getTextPerWeekTime() {
        return setting.getStr("textPerWeek.time", "schedule", "");
    }

    public void setTextPerWeekTime(String textPerWeekTime) {
        setting.setByGroup("textPerWeek.time", textPerWeekTime, "schedule");
    }

    public boolean isRadioCron() {
        return setting.getBool("radioCron", "schedule", false);
    }

    public void setRadioCron(boolean radioCron) {
        setting.setByGroup("radioCron", String.valueOf(radioCron), "schedule");
    }

    public String getTextCron() {
        return setting.getStr("textCron", "schedule", "");
    }

    public void setTextCron(String textCron) {
        setting.setByGroup("textCron", textCron, "schedule");
    }

    public boolean isNeedReimport() {
        return setting.getBool("reimportCheckBox", "schedule", false);
    }

    public void setNeedReimport(boolean needReimport) {
        setting.setByGroup("reimportCheckBox", String.valueOf(needReimport), "schedule");
    }

    public String getReimportWay() {
        return setting.getStr("reimportComboBox", "schedule", "");
    }

    public void setReimportWay(String reimportWay) {
        setting.setByGroup("reimportComboBox", reimportWay, "schedule");
    }

    public boolean isSendPushResult() {
        return setting.getBool("sendPushResult", "schedule", false);
    }

    public void setSendPushResult(boolean sendPushResult) {
        setting.setByGroup("sendPushResult", String.valueOf(sendPushResult), "schedule");
    }

    public String getMailResultTos() {
        return setting.getStr("mailResultTos", "schedule", "");
    }

    public void setMailResultTos(String mailResultTos) {
        setting.setByGroup("mailResultTos", mailResultTos, "schedule");
    }

    public boolean isAutoCheckUpdate() {
        return setting.getBool("autoCheckUpdate", "setting.normal", true);
    }

    public void setAutoCheckUpdate(boolean autoCheckUpdate) {
        setting.setByGroup("autoCheckUpdate", String.valueOf(autoCheckUpdate), "setting.normal");
    }

    public boolean isUseTray() {
        return setting.getBool("useTray", "setting.normal", true);
    }

    public void setUseTray(boolean useTray) {
        setting.setByGroup("useTray", String.valueOf(useTray), "setting.normal");
    }

    public boolean isCloseToTray() {
        return setting.getBool("closeToTray", "setting.normal", true);
    }

    public void setCloseToTray(boolean closeToTray) {
        setting.setByGroup("closeToTray", String.valueOf(closeToTray), "setting.normal");
    }

    public boolean isDefaultMaxWindow() {
        return setting.getBool("defaultMaxWindow", "setting.normal", true);
    }

    public void setDefaultMaxWindow(boolean defaultMaxWindow) {
        setting.setByGroup("defaultMaxWindow", String.valueOf(defaultMaxWindow), "setting.normal");
    }

    public Integer getMaxThreads() {
        return setting.getInt("maxThreads", "setting.normal", 100);
    }

    public void setMaxThreads(Integer maxThreads) {
        setting.setByGroup("maxThreads", String.valueOf(maxThreads), "setting.normal");
    }

    public long getPushTotal() {
        return setting.getLong("pushTotal", "setting.normal", 0L);
    }

    public void setPushTotal(long pushTotal) {
        setting.setByGroup("pushTotal", String.valueOf(pushTotal), "setting.normal");
    }

    public String getBeforeVersion() {
        return setting.getStr("beforeVersion", "setting.normal", "v_3.0.0_190516");
    }

    public void setBeforeVersion(String beforeVersion) {
        setting.setByGroup("beforeVersion", beforeVersion, "setting.normal");
    }

    public String getWechatMpName() {
        return setting.getStr("mpName", "setting.wechat", "默认公众号");
    }

    public void setWechatMpName(String wechatMpName) {
        setting.setByGroup("mpName", wechatMpName, "setting.wechat");
    }

    public String getWechatAppId() {
        return setting.getStr("appId", "setting.wechat", "");
    }

    public void setWechatAppId(String wechatAppId) {
        setting.setByGroup("appId", wechatAppId, "setting.wechat");
    }

    public String getWechatAppSecret() {
        return setting.getStr("AppSecret", "setting.wechat", "");
    }

    public void setWechatAppSecret(String wechatAppSecret) {
        setting.setByGroup("AppSecret", wechatAppSecret, "setting.wechat");
    }

    public String getWechatToken() {
        return setting.getStr("token", "setting.wechat", "");
    }

    public void setWechatToken(String wechatToken) {
        setting.setByGroup("token", wechatToken, "setting.wechat");
    }

    public String getWechatAesKey() {
        return setting.getStr("aesKey", "setting.wechat", "");
    }

    public void setWechatAesKey(String wechatAesKey) {
        setting.setByGroup("aesKey", wechatAesKey, "setting.wechat");
    }

    public boolean isMpUseProxy() {
        return setting.getBool("mpUseProxy", "setting.wechat", false);
    }

    public void setMpUseProxy(boolean mpUseProxy) {
        setting.setByGroup("mpUseProxy", String.valueOf(mpUseProxy), "setting.wechat");
    }

    public String getMpProxyHost() {
        return setting.getStr("mpProxyHost", "setting.wechat", "");
    }

    public void setMpProxyHost(String mpProxyHost) {
        setting.setByGroup("mpProxyHost", mpProxyHost, "setting.wechat");
    }

    public String getMpProxyPort() {
        return setting.getStr("mpProxyPort", "setting.wechat", "");
    }

    public void setMpProxyPort(String mpProxyPort) {
        setting.setByGroup("mpProxyPort", mpProxyPort, "setting.wechat");
    }

    public String getMpProxyUserName() {
        return setting.getStr("mpProxyUserName", "setting.wechat", "");
    }

    public void setMpProxyUserName(String mpProxyUserName) {
        setting.setByGroup("mpProxyUserName", mpProxyUserName, "setting.wechat");
    }

    public String getMpProxyPassword() {
        return setting.getStr("mpProxyPassword", "setting.wechat", "");
    }

    public void setMpProxyPassword(String mpProxyPassword) {
        setting.setByGroup("mpProxyPassword", mpProxyPassword, "setting.wechat");
    }

    public boolean isMpUseOutSideAt() {
        return setting.getBool("mpUseOutSideAt", "setting.wechat", false);
    }

    public void setMpUseOutSideAt(boolean mpUseOutSideAt) {
        setting.setByGroup("mpUseOutSideAt", String.valueOf(mpUseOutSideAt), "setting.wechat");
    }

    public boolean isMpManualAt() {
        return setting.getBool("mpManualAt", "setting.wechat", false);
    }

    public void setMpManualAt(boolean mpManualAt) {
        setting.setByGroup("mpManualAt", String.valueOf(mpManualAt), "setting.wechat");
    }

    public boolean isMpApiAt() {
        return setting.getBool("mpApiAt", "setting.wechat", false);
    }

    public void setMpApiAt(boolean mpApiAt) {
        setting.setByGroup("mpApiAt", String.valueOf(mpApiAt), "setting.wechat");
    }

    public String getMpAt() {
        return setting.getStr("mpAt", "setting.wechat", "");
    }

    public void setMpAt(String mpAt) {
        setting.setByGroup("mpAt", mpAt, "setting.wechat");
    }

    public String getMpAtExpiresIn() {
        return setting.getStr("mpAtExpiresIn", "setting.wechat", "");
    }

    public void setMpAtExpiresIn(String mpAtExpiresIn) {
        setting.setByGroup("mpAtExpiresIn", mpAtExpiresIn, "setting.wechat");
    }

    public String getMpAtApiUrl() {
        return setting.getStr("mpAtApiUrl", "setting.wechat", "");
    }

    public void setMpAtApiUrl(String mpAtApiUrl) {
        setting.setByGroup("mpAtApiUrl", mpAtApiUrl, "setting.wechat");
    }

    public String getAliServerUrl() {
        return setting.getStr("serverUrl", "setting.ali", "");
    }

    public void setAliServerUrl(String aliServerUrl) {
        setting.setByGroup("serverUrl", aliServerUrl, "setting.ali");
    }

    public String getAliAppKey() {
        return setting.getStr("appKey", "setting.ali", "");
    }

    public void setAliAppKey(String aliAppKey) {
        setting.setByGroup("appKey", aliAppKey, "setting.ali");
    }

    public String getAliAppSecret() {
        return setting.getStr("appSecret", "setting.ali", "");
    }

    public void setAliAppSecret(String aliAppSecret) {
        setting.setByGroup("appSecret", aliAppSecret, "setting.ali");
    }

    public String getAliSign() {
        return setting.getStr("sign", "setting.ali", "");
    }

    public void setAliSign(String aliSign) {
        setting.setByGroup("sign", aliSign, "setting.ali");
    }

    public String getMailHost() {
        return setting.getStr("mailHost", "setting.mail", "smtp.163.com");
    }

    public void setMailHost(String mailHost) {
        setting.setByGroup("mailHost", mailHost, "setting.mail");
    }

    public String getMailPort() {
        return setting.getStr("mailPort", "setting.mail", "25");
    }

    public void setMailPort(String mailPort) {
        setting.setByGroup("mailPort", mailPort, "setting.mail");
    }

    public String getMailFrom() {
        return setting.getStr("mailFrom", "setting.mail", "");
    }

    public void setMailFrom(String mailFrom) {
        setting.setByGroup("mailFrom", mailFrom, "setting.mail");
    }

    public String getMailUser() {
        return setting.getStr("mailUser", "setting.mail", "");
    }

    public void setMailUser(String mailUser) {
        setting.setByGroup("mailUser", mailUser, "setting.mail");
    }

    public String getMailPassword() {
        return setting.getStr("mailPassword", "setting.mail", "");
    }

    public void setMailPassword(String mailPassword) {
        setting.setByGroup("mailPassword", mailPassword, "setting.mail");
    }

    public boolean isMailUseStartTLS() {
        return setting.getBool("mailUseStartTLS", "setting.mail", false);
    }

    public void setMailUseStartTLS(boolean mailUseStartTLS) {
        setting.setByGroup("mailUseStartTLS", String.valueOf(mailUseStartTLS), "setting.mail");
    }

    public boolean isMailUseSSL() {
        return setting.getBool("mailUseSSL", "setting.mail", false);
    }

    public void setMailUseSSL(boolean mailUseSSL) {
        setting.setByGroup("mailUseSSL", String.valueOf(mailUseSSL), "setting.mail");
    }

    public String getMysqlUrl() {
        return setting.getStr("url", "setting.mysql", "");
    }

    public void setMysqlUrl(String mysqlUrl) {
        setting.setByGroup("url", mysqlUrl, "setting.mysql");
    }

    public String getMysqlDatabase() {
        return setting.getStr("database", "setting.mysql", "");
    }

    public void setMysqlDatabase(String mysqlDatabase) {
        setting.setByGroup("database", mysqlDatabase, "setting.mysql");
    }

    public String getMysqlUser() {
        return setting.getStr("user", "setting.mysql", "");
    }

    public void setMysqlUser(String mysqlUser) {
        setting.setByGroup("user", mysqlUser, "setting.mysql");
    }

    public String getMysqlPassword() {
        return setting.getStr("password", "setting.mysql", "");
    }

    public void setMysqlPassword(String mysqlPassword) {
        setting.setByGroup("password", mysqlPassword, "setting.mysql");
    }

    public String getTheme() {
        return setting.getStr("theme", "setting.appearance", "Flat Dark");
    }

    public void setTheme(String theme) {
        setting.setByGroup("theme", theme, "setting.appearance");
    }

    public String getFont() {
        if (SystemUtil.isLinuxOs()) {
            return setting.getStr("font", "setting.appearance", "Noto Sans CJK HK");
        } else {
            return setting.getStr("font", "setting.appearance", "微软雅黑");
        }
    }

    public void setFont(String font) {
        setting.setByGroup("font", font, "setting.appearance");
    }

    public int getFontSize() {
        return setting.getInt("fontSize", "setting.appearance", 13);
    }

    public void setFontSize(int fontSize) {
        setting.setByGroup("fontSize", String.valueOf(fontSize), "setting.appearance");
    }

    public String getAliyunAccessKeyId() {
        return setting.getStr("accessKeyId", "setting.aliyun", "");
    }

    public void setAliyunAccessKeyId(String aliyunAccessKeyId) {
        setting.setByGroup("accessKeyId", aliyunAccessKeyId, "setting.aliyun");
    }

    public String getAliyunAccessKeySecret() {
        return setting.getStr("accessKeySecret", "setting.aliyun", "");
    }

    public void setAliyunAccessKeySecret(String aliyunAccessKeySecret) {
        setting.setByGroup("accessKeySecret", aliyunAccessKeySecret, "setting.aliyun");
    }

    public String getAliyunSign() {
        return setting.getStr("aliyunSign", "setting.aliyun", "");
    }

    public void setAliyunSign(String aliyunSign) {
        setting.setByGroup("aliyunSign", aliyunSign, "setting.aliyun");
    }

    public String getMiniAppName() {
        return setting.getStr("name", "setting.miniApp", "默认小程序");
    }

    public void setMiniAppName(String miniAppName) {
        setting.setByGroup("name", miniAppName, "setting.miniApp");
    }

    public String getMiniAppAppId() {
        return setting.getStr("appId", "setting.miniApp", "");
    }

    public void setMiniAppAppId(String miniAppAppId) {
        setting.setByGroup("appId", miniAppAppId, "setting.miniApp");
    }

    public String getMiniAppAppSecret() {
        return setting.getStr("AppSecret", "setting.miniApp", "");
    }

    public void setMiniAppAppSecret(String miniAppAppSecret) {
        setting.setByGroup("AppSecret", miniAppAppSecret, "setting.miniApp");
    }

    public String getMiniAppToken() {
        return setting.getStr("token", "setting.miniApp", "");
    }

    public void setMiniAppToken(String miniAppToken) {
        setting.setByGroup("token", miniAppToken, "setting.miniApp");
    }

    public String getMiniAppAesKey() {
        return setting.getStr("aesKey", "setting.miniApp", "");
    }

    public void setMiniAppAesKey(String miniAppAesKey) {
        setting.setByGroup("aesKey", miniAppAesKey, "setting.miniApp");
    }

    public boolean isMaUseProxy() {
        return setting.getBool("maUseProxy", "setting.wechat", false);
    }

    public void setMaUseProxy(boolean maUseProxy) {
        setting.setByGroup("maUseProxy", String.valueOf(maUseProxy), "setting.wechat");
    }

    public String getMaProxyHost() {
        return setting.getStr("maProxyHost", "setting.wechat", "");
    }

    public void setMaProxyHost(String maProxyHost) {
        setting.setByGroup("maProxyHost", maProxyHost, "setting.wechat");
    }

    public String getMaProxyPort() {
        return setting.getStr("maProxyPort", "setting.wechat", "");
    }

    public void setMaProxyPort(String maProxyPort) {
        setting.setByGroup("maProxyPort", maProxyPort, "setting.wechat");
    }

    public String getMaProxyUserName() {
        return setting.getStr("maProxyUserName", "setting.wechat", "");
    }

    public void setMaProxyUserName(String maProxyUserName) {
        setting.setByGroup("maProxyUserName", maProxyUserName, "setting.wechat");
    }

    public String getMaProxyPassword() {
        return setting.getStr("maProxyPassword", "setting.wechat", "");
    }

    public void setMaProxyPassword(String maProxyPassword) {
        setting.setByGroup("maProxyPassword", maProxyPassword, "setting.wechat");
    }

    public String getWxCpCorpId() {
        return setting.getStr("wxCpCorpId", "setting.wechat", "");
    }

    public void setWxCpCorpId(String wxCpCorpId) {
        setting.setByGroup("wxCpCorpId", wxCpCorpId, "setting.wechat");
    }

    public String getTxyunAppId() {
        return setting.getStr("appId", "setting.txyun", "");
    }

    public void setTxyunAppId(String txyunAppId) {
        setting.setByGroup("appId", txyunAppId, "setting.txyun");
    }

    public String getTxyunAppKey() {
        return setting.getStr("appKey", "setting.txyun", "");
    }

    public void setTxyunAppKey(String txyunAppKey) {
        setting.setByGroup("appKey", txyunAppKey, "setting.txyun");
    }

    public String getTxyunSign() {
        return setting.getStr("txyunSign", "setting.txyun", "");
    }

    public void setTxyunSign(String txyunSign) {
        setting.setByGroup("txyunSign", txyunSign, "setting.txyun");
    }

    public String getHwAppKey() {
        return setting.getStr("hwAppKey", "setting.hwyun", "");
    }

    public void setHwAppKey(String hwAppKey) {
        setting.setByGroup("hwAppKey", hwAppKey, "setting.hwyun");
    }

    public String getHwAppSecretPassword() {
        return setting.getStr("hwAppSecretPassword", "setting.hwyun", "");
    }

    public void setHwAppSecretPassword(String hwAppSecretPassword) {
        setting.setByGroup("hwAppSecretPassword", hwAppSecretPassword, "setting.hwyun");
    }

    public String getHwAccessUrl() {
        return setting.getStr("hwAccessUrl", "setting.hwyun", "");
    }

    public void setHwAccessUrl(String hwAccessUrl) {
        setting.setByGroup("hwAccessUrl", hwAccessUrl, "setting.hwyun");
    }

    public String getHwSignature() {
        return setting.getStr("hwSignature", "setting.hwyun", "");
    }

    public void setHwSignature(String hwSignature) {
        setting.setByGroup("hwSignature", hwSignature, "setting.hwyun");
    }

    public String getHwSenderCode() {
        return setting.getStr("hwSenderCode", "setting.hwyun", "");
    }

    public void setHwSenderCode(String hwSenderCode) {
        setting.setByGroup("hwSenderCode", hwSenderCode, "setting.hwyun");
    }

    public String getBdSecretAccessKey() {
        return setting.getStr("bdSecretAccessKey", "setting.bdyun", "");
    }

    public void setBdSecretAccessKey(String bdSecretAccessKey) {
        setting.setByGroup("bdSecretAccessKey", bdSecretAccessKey, "setting.bdyun");
    }

    public String getBdAccessKeyId() {
        return setting.getStr("bdAccessKeyId", "setting.bdyun", "");
    }

    public void setBdAccessKeyId(String bdAccessKeyId) {
        setting.setByGroup("bdAccessKeyId", bdAccessKeyId, "setting.bdyun");
    }

    public String getBdEndPoint() {
        return setting.getStr("bdEndPoint", "setting.bdyun", "");
    }

    public void setBdEndPoint(String bdEndPoint) {
        setting.setByGroup("bdEndPoint", bdEndPoint, "setting.bdyun");
    }

    public String getBdInvokeId() {
        return setting.getStr("bdInvokeId", "setting.bdyun", "");
    }

    public void setBdInvokeId(String bdInvokeId) {
        setting.setByGroup("bdInvokeId", bdInvokeId, "setting.bdyun");
    }

    public String getUpAuthorizationToken() {
        return setting.getStr("upAuthorizationToken", "setting.upyun", "");
    }

    public void setUpAuthorizationToken(String upAuthorizationToken) {
        setting.setByGroup("upAuthorizationToken", upAuthorizationToken, "setting.upyun");
    }

    public String getQiniuAccessKey() {
        return setting.getStr("qiniuAccessKey", "setting.qiniu", "");
    }

    public void setQiniuAccessKey(String qiniuAccessKey) {
        setting.setByGroup("qiniuAccessKey", qiniuAccessKey, "setting.qiniu");
    }

    public String getQiniuSecretKey() {
        return setting.getStr("qiniuSecretKey", "setting.qiniu", "");
    }

    public void setQiniuSecretKey(String qiniuSecretKey) {
        setting.setByGroup("qiniuSecretKey", qiniuSecretKey, "setting.qiniu");
    }

    public String getYunpianApiKey() {
        return setting.getStr("apiKey", "setting.yunpian", "");
    }

    public void setYunpianApiKey(String yunpianApiKey) {
        setting.setByGroup("apiKey", yunpianApiKey, "setting.yunpian");
    }

    public boolean isHttpUseProxy() {
        return setting.getBool("httpUseProxy", "setting.http", false);
    }

    public void setHttpUseProxy(boolean httpUseProxy) {
        setting.setByGroup("httpUseProxy", String.valueOf(httpUseProxy), "setting.http");
    }

    public String getHttpProxyHost() {
        return setting.getStr("httpProxyHost", "setting.http", "");
    }

    public void setHttpProxyHost(String httpProxyHost) {
        setting.setByGroup("httpProxyHost", httpProxyHost, "setting.http");
    }

    public String getHttpProxyPort() {
        return setting.getStr("httpProxyPort", "setting.http", "");
    }

    public void setHttpProxyPort(String httpProxyPort) {
        setting.setByGroup("httpProxyPort", httpProxyPort, "setting.http");
    }

    public String getHttpProxyUserName() {
        return setting.getStr("httpProxyUserName", "setting.http", "");
    }

    public void setHttpProxyUserName(String httpProxyUserName) {
        setting.setByGroup("httpProxyUserName", httpProxyUserName, "setting.http");
    }

    public String getHttpProxyPassword() {
        return setting.getStr("httpProxyPassword", "setting.http", "");
    }

    public void setHttpProxyPassword(String httpProxyPassword) {
        setting.setByGroup("httpProxyPassword", httpProxyPassword, "setting.http");
    }

    public Integer getWxAccountId() {
        return setting.getInt("wxAccountId", "setting.wechat");
    }

    public void setWxAccountId(Integer wxAccountId) {
        setting.setByGroup("wxAccountId", String.valueOf(wxAccountId), "setting.wechat");
    }
}
