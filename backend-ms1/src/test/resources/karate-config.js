function fn() {

    
    var config = {};
    
   
    const rootUrlDev = 'http://localhost:8036/';
    const adminCredentialsDev = {"username": "admin","password": "123"};
    const urlDev = 'jdbc:mysql://localhost:3306/peps-order';
    const usernameDev = 'root';
    const passwordDev = '';
    const driverDev = 'com.mysql.cj.jdbc.Driver';


    const rootUrlInit = 'https://stage-host/';
    const adminCredentialsInit = {"username": "admin","password": "123"};
    const urlInit = 'jdbc:mysql://localhost:3306/peps-order';
    const usernameInit = 'root';
    const passwordInit = '';
    const driverInit = 'com.mysql.cj.jdbc.Driver';
    
    
    const rootUrlE2e = 'https://e2e-host/';
    const adminCredentialsE2e = {"username": "admin","password": "123"};
    const urlE2e = 'jdbc:mysql://localhost:3306/peps-order';
    const usernameE2e = 'root';
    const passwordE2e = '';
    const driverE2e = 'com.mysql.cj.jdbc.Driver';
    
    var env = karate.env; // get java system property 'karate.env'
    if (!env || env=='dev') {
        env = 'dev';
        config.rootUrl = rootUrlDev;
        config.adminCredentials = adminCredentialsDev;
        config.datasource = { username: usernameDev, password: passwordDev, url: urlDev, driverClassName: driverDev }
    }
    if (env == 'int') {
        // over-ride only those that need to be
        config.rootUrl = rootUrlInit;
        config.adminCredentials = adminCredentialsInit;
        config.datasource = { username: usernameInit, password: passwordInit, url: urlInit, driverClassName: driverInit }
    } else if (env == 'e2e') {
        config.rootUrl = rootUrlE2e;
        config.adminCredentials = adminCredentialsE2e;
        config.datasource = { username: usernameE2e, password: passwordE2e, url: urlE2e, driverClassName: driverE2e }
    }

    config.actuatorUri = config.rootUrl + 'actuator/';
    config.adminUri = config.rootUrl + 'api/admin/';

        config.subDomainTemplateUrl = config.adminUri + 'subDomainTemplate/';
    config.categoryProjectTemplateUrl = config.adminUri + 'categoryProjectTemplate/';
    config.paimentCollaboratorStateUrl = config.adminUri + 'paimentCollaboratorState/';
    config.projectUrl = config.adminUri + 'project/';
    config.projectStateUrl = config.adminUri + 'projectState/';
    config.paimentInfluencerUrl = config.adminUri + 'paimentInfluencer/';
    config.inscriptionCollaboratorUrl = config.adminUri + 'inscriptionCollaborator/';
    config.domainTemplateUrl = config.adminUri + 'domainTemplate/';
    config.memberUrl = config.adminUri + 'member/';
    config.inscriptionStateUrl = config.adminUri + 'inscriptionState/';
    config.packagingUrl = config.adminUri + 'packaging/';
    config.categoryPackagingUrl = config.adminUri + 'categoryPackaging/';
    config.couponUrl = config.adminUri + 'coupon/';
    config.collaboratorUrl = config.adminUri + 'collaborator/';
    config.influencerUrl = config.adminUri + 'influencer/';
    config.paimentCollaboratorUrl = config.adminUri + 'paimentCollaborator/';
    config.projectTemplateUrl = config.adminUri + 'projectTemplate/';
    config.paimentInfluencerStateUrl = config.adminUri + 'paimentInfluencerState/';

    common = karate.callSingle('classpath:common.feature', config);
    config.uniqueId = common.uniqueId
    config.db = common.db
    config.adminToken = common.adminToken
    config.env = env;

    karate.log('karate.env =', karate.env);
    karate.log('config =', config);
    // don't waste time waiting for a connection or if servers don't respond within 5 seconds
    karate.configure('connectTimeout', 5000);
    karate.configure('readTimeout', 5000);
    return config;
}
