LOAD DATA
INFILE 'D:\javadata\sejong.csv'
INSERT INTO TABLE POSTCODE
FIELDS TERMINATED BY ','
TRAILING NULLCOLS(
  NEW_POST_CODE,
  SIDO_KOR,
  SIDO_ENG,
  GUGUN_KOR,
  GUGUN_ENG,
  UPMYON_KOR,
  UPMYON_ENG,
  DORO_NUMBER,
  DORO_KOR,
  DORO_ENG,
  UNDOR_FLAG,
  BUILDING_ORIGIN_NUMBER,
  BUILDING_REFER_NUMBER,
  BUILDING_MANAGE_NUMBER,
  MULTI_DELIVER_NAME,
  SIGUGUN_BUILDING_NAME,
  LAW_DONG_NUMBER,
  LAW_DONG_NAME,
  RI_NAME,
  ADMIN_DONG_NAME,
  SAN_FLAG,
  JIBEON_BONBEON,
  UPMYONDONG_SEQ,
  JIBEON_BUBEON,
  OLD_POST_CODE,
  POST_CODE_SEQ
) 