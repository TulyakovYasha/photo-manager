DROP TABLE PHOTO;
DROP TABLE PICTURE;
CREATE TABLE PHOTO (
                               id INT NOT NULL GENERATED ALWAYS AS IDENTITY ,
                               page INT NOT NULL,
                               page_count INT NOT NULL,
                               has_more boolean not null
);

CREATE TABLE PICTURE(
                        id INT NOT NULL GENERATED ALWAYS AS IDENTITY ,
                        external_id VARCHAR NOT NULL,
                        cropped_picture VARCHAR NOT NULL,
                        photo_id  INT,
                        foreign key (photo_id) references PHOTO(id)
);