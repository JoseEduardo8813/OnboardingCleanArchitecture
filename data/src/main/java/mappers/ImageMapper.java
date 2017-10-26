package mappers;


import com.globant.equattrocchio.data.response.Image;
import com.globant.equattrocchio.domain.domian.ImageDomain;

import java.util.ArrayList;
import java.util.List;

public class ImageMapper {

    public static ImageDomain imageToDomainImage(Image image) {
        ImageDomain imageDomain = new ImageDomain();
        imageDomain.setUrl(image.getUrl());
        return imageDomain;
    }

    public static List<ImageDomain> imageToDomainImage(List<Image> images) {
        List<ImageDomain> imagesDomain = new ArrayList<>();
        for (Image image : images) {
            imagesDomain.add(imageToDomainImage(image));
        }
        return imagesDomain;
    }
}
