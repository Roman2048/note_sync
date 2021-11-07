module net.longday.netnote {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;
    requires kotlinx.coroutines.core.jvm;
    requires com.google.gson;
    requires okhttp3;


    opens net.longday.netnote to javafx.fxml;
    opens net.longday.netnote.controller to javafx.fxml;
    exports net.longday.netnote;
}