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
          "headers": {}
        }
      });
      print('RESULT -> $jsonString');
    } on PlatformException catch (e) {
      print(e);
    }
    return placeHolderFromJson(jsonString);
  }

// Future<String> post() async {
//   try {
//     final String result = await platform.invokeMethod("POST", {
//       "body": color,
//     });
//     print('RESULT -> $result');
//     color = result;
//   } on PlatformException catch (e) {
//     print(e);
//   }
//   return color;
// }

}
