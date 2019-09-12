var crypto = require('crypto');

var params = {};
params.qstring = { app_key: '0baa33161797f763ded13aa5ce86ed1f27df4aa8',
  device_id: 'OwnUserID',
  timestamp: '1568173208818',
  hour: '11',
  dow: '3',
  tz: '480',
  sdk_version: '19.02',
  sdk_name: 'objc-native-ios',
  session_duration: '60' 
}

let app_user_id = crypto.createHash('sha1')
.update(params.qstring.app_key + params.qstring.device_id + "")
.digest('hex');

console.log("===============");

console.log(app_user_id);
