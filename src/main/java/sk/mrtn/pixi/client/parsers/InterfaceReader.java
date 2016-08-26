package sk.mrtn.pixi.client.parsers;

import elemental.json.JsonArray;
import elemental.json.JsonObject;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by klaun on 30/05/16.
 */

//        InterfaceReader.parseObjectAndOutputToConsole("PIXI");
//        PIXI pixi = new PIXI(elementById);
//        InterfaceReader.parseObjectAndOutputToConsole(pixi, "PIXI");

public class InterfaceReader {

    static String EOL = "\n";
    private static final String STATIC_PLACEHOLDER = EOL + "${staticPlaceholder}" + EOL;
    private static final String DYNAMIC_PLACEHOLDER = EOL + "${dynamicPlaceholder}" + EOL;
    static String TAB = "    ";

    public static void parseObjectAndOutputToConsole(Object object, String name) {
        defineArgumentsDetector();
        generateClassFromObject(object,name);
    }

    public static void parseObjectAndOutputToConsole(String name) {
        defineArgumentsDetector();
        generateClassFromName(name);
    }

    private static void generateClassFromObject(Object object, String name) {
        JsonObject jObject = iterateOverProperties0(object, name);
        Logger LOG = Logger.getLogger("common");
        LOG.setLevel(Level.ALL);
        LOG.info("Parsing ["+jObject.getString("type")+"] ");
        String cString = new String();
        cString = generateClass(jObject, cString);
        LOG.fine(cString);
        saveToFile(jObject.getString("name")+".java",cString);
        List<String> strings = parseObjects(jObject);
        for (String string : strings) {
            generateClassFromName(name+"."+string);
        }

    }

    private static void generateClassFromName(String name) {
        JsonObject jObject = iterateOverProperties0(name);
        Logger LOG = Logger.getLogger("common");
        LOG.setLevel(Level.ALL);
        LOG.info("Parsing ["+jObject.getString("type")+"] "+ name);
        String cString = new String();
        cString = generateClass(jObject, cString);
        LOG.fine(cString);
        saveToFile(jObject.getString("name")+".java",cString);
        List<String> strings = parseStaticObjects(jObject);
        for (String string : strings) {
            generateClassFromName(name+"."+string);
        }

    }

    private static String generateClass(JsonObject object, String cString) {
        cString+= parseHeaderAndConstructor(object);
        cString = cString.replace(STATIC_PLACEHOLDER, parseStaticFields(object)+ STATIC_PLACEHOLDER);
        cString = cString.replace(STATIC_PLACEHOLDER, parseStaticMethods(object));
        cString = cString.replace(DYNAMIC_PLACEHOLDER, parseDynamicFields(object)+ DYNAMIC_PLACEHOLDER);
        cString = cString.replace(DYNAMIC_PLACEHOLDER, parseDynamicMethods(object));
        cString += "}"+EOL;
//        cString += "-----------------------------------------------";
        return cString;
    }

    private static String parseHeaderAndConstructor(JsonObject object) {
        String cString;
        String namespace = object.getString("namespace");
        if (object.getString("type").equals("object")) {
            cString = EOL+"@JsType(isNative = true)"+EOL;
        } else if (namespace.equals("")) {
            cString = EOL+"@JsType(isNative = true, namespace = JsPackage.GLOBAL )"+EOL;
        } else {
            cString = EOL+"@JsType(isNative = true, namespace = \""+ namespace +"\")"+EOL;
        }
        cString += "public class "+object.getString("name")+ " {"+EOL;
        cString += STATIC_PLACEHOLDER;
        cString += EOL;
        JsonObject constructor = object.getObject("$constructor$");
        if (constructor != null) {
            cString += TAB+"@JsConstructor" + EOL;
            cString += TAB+"public "+constructor.getString("name")+"(";
            JsonArray sArgs = constructor.getArray("args");
            for (int i = 0; i < sArgs.length(); i++) {
                cString+= getParameterAndType(sArgs.get(i));
                if (i<sArgs.length()-1) cString+=", ";
            }
            cString +="){};" + EOL;
        }

        cString += DYNAMIC_PLACEHOLDER;
        cString += EOL;

        return cString;
    }

    private static List<String> parseStaticObjects(JsonObject object) {
        List<String > list = new ArrayList<>();
        if (object.getString("type").equals("object")) return list;
        return parseObjects(object);
    }
    private static List<String> parseObjects(JsonObject object) {
        List<String > list = new ArrayList<>();

        JsonObject keys = object.getObject("KEYS");
        for (String key : keys.keys()) {
            JsonObject sProp = keys.getObject(key);
            String sType = sProp.getString("type");
            switch (sType) {
                case "function":
                    if (key.substring(0,1).equals(key.substring(0,1).toUpperCase())) {
                        list.add(key);
                    }
            }
        }
        return list;
    }

    private static String parseDynamicMethods(JsonObject object) {
        if (object.getString("type").equals("class")) return "";
        String methodTypeComment = "";
        String methodTypeDecl = "";
        return parseMethods(object, methodTypeComment, methodTypeDecl);
    }
    private static String parseStaticMethods(JsonObject object) {
        if (object.getString("type").equals("object")) return "";
        String methodTypeComment = " STATIC";
        String methodTypeDecl = " static";
        return parseMethods(object, methodTypeComment, methodTypeDecl);
    }

    private static String parseMethods(JsonObject object, String methodTypeComment, String methodTypeDecl) {
        String staticMethods = EOL+TAB+"// PUBLIC"+methodTypeComment+" METHODS"+EOL;
        JsonObject keys = object.getObject("KEYS");
        for (String key : keys.keys()) {
            JsonObject sProp = keys.getObject(key);
            String sType = sProp.getString("type");
            switch (sType) {
                case "function":
                    if (key.substring(0,1).equals(key.substring(0,1).toLowerCase())) {
                        staticMethods += TAB+"@JsMethod" + EOL;
                        staticMethods += TAB+"public"+methodTypeDecl+" native "+getParameterAndType(key)+"(";
                        JsonArray sArgs = sProp.getArray("args");
                        for (int i = 0; i < sArgs.length(); i++) {
                            staticMethods+= getParameterAndType(sArgs.get(i));
                            if (i<sArgs.length()-1) staticMethods+=", ";
                        }
                        staticMethods +=");" + EOL;
                    }
            }
        }
        return staticMethods;
    }

    private static String parseDynamicFields(JsonObject object) {
        if (object.getString("type").equals("class")) return "";
        String propertyTypeDecl = "";
        String propertyTypeComment = "";

        return parseFields(object, propertyTypeDecl, propertyTypeComment);
    }
    private static String parseStaticFields(JsonObject object) {
        if (object.getString("type").equals("object")) return "";
        String propertyTypeDecl = " static";
        String propertyTypeComment = " STATIC";

        return parseFields(object, propertyTypeDecl, propertyTypeComment);
    }

    private static String parseFields(JsonObject object, String propertyTypeDecl, String propertyTypeComment) {
        String staticjsProps = EOL+TAB+ "// PUBLIC" + propertyTypeComment + " FIELDS" +EOL;
        JsonObject keys = object.getObject("KEYS");
        for (String key : keys.keys()) {
            JsonObject sProp = keys.getObject(key);
            String sType = sProp.getString("type");
            switch (sType) {
                case "number":
                    double sValue = sProp.getNumber("value");
                    staticjsProps += TAB+"@JsProperty" + EOL;

                    if (sValue == (int) sValue) {
                        staticjsProps += TAB+ "public" + propertyTypeDecl + " int " +key+";" + EOL;
                    } else {
                        staticjsProps += TAB+ "public" + propertyTypeDecl + " double " +key+";" + EOL;
                    }
                    break;
                case "string":
                    staticjsProps += TAB+"@JsProperty" + EOL;
                    staticjsProps += TAB+ "public" + propertyTypeDecl + " String " +key+";" + EOL;
                    break;
                case "object":
                    staticjsProps += TAB+"@JsProperty" + EOL;
                    staticjsProps += TAB+ "public" + propertyTypeDecl + " Object " +key+";" + EOL;
                    break;
                case "boolean":
                    staticjsProps += TAB+"@JsProperty" + EOL;
                    staticjsProps += TAB+ "public" + propertyTypeDecl + " boolean " +key+";" + EOL;
                    break;
            }
        }
        return staticjsProps;
    }

    private static String getParameterAndType(String parameter) {
        switch (parameter) {
            case "element" :
                return "Element "+parameter;
            case "manager" :
                return "Manager "+parameter;
            default:
                return "Tmp "+parameter;
        }
    }

    public static native JsonObject iterateOverProperties0(Object obj, String name) /*-{
        var keys = Object.keys(obj);
        var prototypeKeys = Object.keys(Object.getPrototypeOf(obj));
        for (var i = 0; i < prototypeKeys.length; i++) {
            keys.push(prototypeKeys[i])
        }
        var json = {};
        json["name"] = name;
        json["namespace"] = "";
        json["type"] = "object"
        json["KEYS"] = {};
        for(id in keys) {
            $wnd.console.log("coco:"+key)
            var key     = keys[id];
            // if (!obj.hasOwnProperty(key)) continue;
            if (key.charAt(0) == "_") continue;
            var value   = obj[key];
            var keyType = typeof value;
            switch(keyType) {
                case "number":
                case "boolean":
                case "object":
                case "string":
                    json["KEYS"][key] = {"type":keyType,"value":value}
                    break;
                case "function":
                    var args = $wnd.getArgs(value);
                    json["KEYS"][key] = {"type":keyType, "args":args}
                    break;
                case "undefined":
                    $wnd.console.warn("ignoring undefined for key: " + key);
                    break;
                default:
                    $wnd.console.error("unimplemented type: "+keyType + " for key: " + key);
            }
        }
        $wnd.console.info(json)
        $wnd.console.info(obj)
        return json
    }-*/;

    public static native JsonObject iterateOverProperties0(String objectId) /*-{
        var path = objectId.split(".");
        var namespace = path.slice(0,path.length-1).join(".")
        var constructor = path.shift()
        var obj = $wnd[constructor]
        while (path.length > 0) {
            constructor = path.shift()
            obj = obj[constructor]
        }
        console.info("parsing: "+objectId)
        var keys = Object.keys(obj);
        var json = {};
        json["name"] = constructor;
        json["namespace"] = namespace;
        if (typeof obj == "function") {
            json["$constructor$"] = {"name":constructor, "args":$wnd.getArgs(obj)}
            json["type"] = "class"
        } else {
            json["type"] = "object"
        }
        json["KEYS"] = {};
        for(id in keys) {
            var key     = keys[id];
            var value   = obj[key];
            var keyType = typeof value;
            switch(keyType) {
                case "boolean":
                case "number":
                case "string":
                    json["KEYS"][key] = {"type":keyType,"value":value}
                    break;
                case "function":
                    var args = $wnd.getArgs(value);
                    json["KEYS"][key] = {"type":keyType, "args":args}
                    break;
                default:

            }
        }
        console.log(json)
        return json
    }-*/;

    public static native void defineArgumentsDetector() /*-{
        $wnd.getArgs = function (func) {
          // First match everything inside the function argument parens.
          var args = func.toString().match(/function\s.*?\(([^)]*)\)/)[1];

          // Split the arguments string into an array comma delimited.
          return args.split(',').map(function(arg) {
            // Ensure no inline comments are parsed and trim the whitespace.
            return arg.replace(/\/\*.*\*\//, '').trim();
          }).filter(function(arg) {
            // Ensure no undefined values are added.
            return arg;
          });
        }
    }-*/;

    public static native void saveToFile(String filename, String text) /*-{
        function download(filename, text) {
          var element = document.createElement('a');
          element.setAttribute('href', 'data:text/plain;charset=utf-8,' + encodeURIComponent(text));
          element.setAttribute('download', filename);

          element.style.display = 'none';
          document.body.appendChild(element);

          element.click();

          document.body.removeChild(element);
        }
        download(filename,text)
    }-*/;



}
