package CAITproject.CAIT.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOError;
import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryService {

    @Autowired
    private Cloudinary cloudinary;

    public String uploadImage(MultipartFile file) throws IOException{
        Map<?,?> result = cloudinary.uploader().upload(
                file.getBytes(),
                ObjectUtils.asMap(
                        "resource_type","image"
                )
        );

        return result.get("secure_url").toString();
    }

    public void deleteImage(String url)throws IOException{
        String publicId = url.substring(url.lastIndexOf("/")+1);

        publicId = publicId.substring(0,publicId.lastIndexOf("."));

        cloudinary.uploader().destroy(publicId,ObjectUtils.asMap(
                "resource_type", "image",
                "type", "upload",
                "invalidate", true
        ));
    }
}
