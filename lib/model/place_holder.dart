// To parse this JSON data, do
//
//     final placeHolder = placeHolderFromJson(jsonString);

import 'package:meta/meta.dart';
import 'dart:convert';

List<PlaceHolder> placeHolderFromJson(String str) => List<PlaceHolder>.from(json.decode(str).map((x) => PlaceHolder.fromJson(x)));

String placeHolderToJson(List<PlaceHolder> data) => json.encode(List<dynamic>.from(data.map((x) => x.toJson())));

class PlaceHolder {
  PlaceHolder({
    required this.userId,
    required this.id,
    required this.title,
    required this.body,
  });

  int userId;
  int id;
  String title;
  String body;

  factory PlaceHolder.fromJson(Map<String, dynamic> json) => PlaceHolder(
    userId: json["userId"],
    id: json["id"],
    title: json["title"],
    body: json["body"],
  );

  Map<String, dynamic> toJson() => {
    "userId": userId,
    "id": id,
    "title": title,
    "body": body,
  };
}
