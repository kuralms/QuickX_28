package quickstartx.kural.activitys;

import java.util.List;

import quickstartx.kural.activitys.objects.Images;

public interface HomeContract {
    interface View {

        void initV();

        void showError(String message);

        void loadDataInList(List<Images> images);

    }

    interface Presenter {

        void start();

        void loadImages();

        void initP();
    }
}
