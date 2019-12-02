db.banks.insert({
	'_id' : 1,
    'name' : 'bankTest',
    'queue' : 'testTranslator',
    'timeWaitOfTranslatorResponse' : 120000,
    'ttlUserSession' : 900000
});
db.routes.insert({
	'bankId' : 1,
	'operation' : 'PRE_SESSION',
	'serviceActivator' : 'checkLogin'
});

db.routes.insert({
	'bankId' : 1,
	'operation' : 'SESSION',
	'serviceActivator' : 'login'
});
db.routes.insert({
	'bankId' : 1,
	'operation' : 'DELETE_SESSION',
	'serviceActivator' : 'logout'
});
