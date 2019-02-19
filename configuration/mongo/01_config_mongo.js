db.banks.insert({
	'_id' : 1,
    'name' : 'bankTest',
    'queue' : 'testTranslator',
    'ttlUserSession' : 300
});
db.routes.insert({
	'bankId' : 1,
	'operation' : 'CHECK_LOGIN',
	'serviceActivator' : 'checkLogin'
});

db.routes.insert({
	'bankId' : 1,
	'operation' : 'LOGIN',
	'serviceActivator' : 'login'
});
db.routes.insert({
	'bankId' : 1,
	'operation' : 'LOGOUT',
	'serviceActivator' : 'logout'
});