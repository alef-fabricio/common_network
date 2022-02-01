import 'package:common_network/model/place_holder.dart';
import 'package:common_network/repositories/connect.dart';
import 'package:flutter/material.dart';

class MyHomePage extends StatefulWidget {
  const MyHomePage({Key? key, required this.title}) : super(key: key);

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  final _repository = WispRepository();
  List<PlaceHolder> placeHolders = [];

  void _fetchData() {
    _repository.get().then((value) {
      setState(() {
        placeHolders?.clear();
        placeHolders.addAll(value);
      });
    });
  }

  @override
  Widget build(BuildContext context) {
    print("teste rebuild");
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: <Widget>[
          if (placeHolders.isNotEmpty)
            Expanded(
                child: Padding(
                  padding: EdgeInsets.all(10),
                  child: ListView.builder(
                  itemCount: placeHolders.length,
                  itemBuilder: (context, index) {
                    return ListTile(
                      leading: Text(placeHolders[index].id.toString()),
                      title: Text(placeHolders[index].title),
                      subtitle: Text(placeHolders[index].body),
                    );
                  },
                ),))
        ],
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: _fetchData,
        child: const Icon(Icons.image_search_outlined),
      ), // This trailing comma makes auto-formatting nicer for build methods.
    );
  }
}
