var exec = require('cordova/exec');

var PLUGIN_NAME = 'SimplePlugin';

var SimplePlugin = {
  echo: function(phrase, success, error) {
    exec(success, error, PLUGIN_NAME, "echo", [phrase]);
  },
  echojs: function(phrase, success, error) {
    if (phrase && typeof(phrase) === 'string' && phrase.length > 0) {
      success(phrase);
    } else {
      error('Empty message!');
    }
  },
  getDate: function(callback) {
    exec(callback, null, PLUGIN_NAME, 'getDate', []);
  }
};

module.exports = SimplePlugin;