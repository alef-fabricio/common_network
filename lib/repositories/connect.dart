import 'package:common_network/model/place_holder.dart';
import 'package:flutter/services.dart';

class WispRepository {
  static const platform = MethodChannel('io.unico.app/network');

  Future<List<PlaceHolder>> get() async {
    var jsonString;

    try {
      String url = "https://jsonplaceholder.typicode.com/posts";
      jsonString = await platform.invokeMethod("GET", {
        "url": url,
        "options": {
          "headers": {"Accept":  "application/vnd.github.v3.full+json"}
        }
      });
      print('RESULT -> $jsonString');
    } on PlatformException catch (e) {
      print(e);
    }
    return placeHolderFromJson(jsonString);
  }

  Future<List<PlaceHolder>> post() async {
    var jsonString;

    try {
      String url = "https://jsonplaceholder.typicode.com/posts";
      jsonString = await platform.invokeMethod("POST", {
        "url": url,
        "body": {
          "title": "foo",
          "body": "bar",
          "userId": 1
        },
        "options": {
          "headers": {'Content-type': 'application/json; charset=UTF-8'}
        }
      });
      print('RESULT -> $jsonString');
    } on PlatformException catch (e) {
      print(e);
    }
    return placeHolderFromJson(jsonString);
  }

  Future<List<PlaceHolder>> put() async {
    var jsonString;

    try {
      String url = "https://jsonplaceholder.typicode.com/posts/1";
      jsonString = await platform.invokeMethod("PUT", {
        "url": url,
        "body": {
          "title": "foo",
          "body": "bar",
          "userId": 1
        },
        "options": {
          "headers": {'Content-type': 'application/json; charset=UTF-8'}
        }
      });
      print('RESULT -> $jsonString');
    } on PlatformException catch (e) {
      print(e);
    }
    return placeHolderFromJson(jsonString);
  }

  Future<List<PlaceHolder>> patch() async {
    var jsonString;

    try {
      String url = "https://jsonplaceholder.typicode.com/posts/1";
      jsonString = await platform.invokeMethod("PATCH", {
        "url": url,
        "body": {
          "title": "foo"
        },
        "options": {
          "headers": {'Content-type': 'application/json; charset=UTF-8'}
        }
      });
      print('RESULT -> $jsonString');
    } on PlatformException catch (e) {
      print(e);
    }
    return placeHolderFromJson(jsonString);
  }

  Future<List<PlaceHolder>> delete() async {
    var jsonString;

    try {
      String url = "https://jsonplaceholder.typicode.com/posts/1";
      jsonString = await platform.invokeMethod("DELETE", {
        "url": url,
        "options": {
          "headers": {'Content-type': 'application/json; charset=UTF-8'}
        }
      });
      print('RESULT -> $jsonString');
    } on PlatformException catch (e) {
      print(e);
    }
    return placeHolderFromJson(jsonString);
  }

}
