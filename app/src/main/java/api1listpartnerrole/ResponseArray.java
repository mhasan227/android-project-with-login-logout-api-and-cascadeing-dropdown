package api1listpartnerrole;

import android.location.Location;

public class ResponseArray {

     String id;
     String userId;
     String password;
     String name;
     String requestTime;
     Role[] role;
     TaggedMerchantIds[] taggedMerchantIds;

     String phoneNumber;
     String email;
     String deviceId;
     String installationId;
     String rand;
     String browserAgent;
     LocationLongLat location;

     String region;
     String area;
     String teritory;
     String district;
     String thana;
     String photo;
     String onBoardingStatus;
     String keyAccountManagerId;
     String introducerId;
     String attemptId;
     String creatorOrganizationId;
     String creatorUserId;
     String creationDate;

     public ResponseArray(String id, String userId, String password, String name, String requestTime, Role[] role, TaggedMerchantIds[] taggedMerchantIds, String phoneNumber, String email, String deviceId, String installationId, String rand, String browserAgent, LocationLongLat location, String region, String area, String teritory, String district, String thana, String photo, String onBoardingStatus, String keyAccountManagerId, String introducerId, String attemptId, String creatorOrganizationId, String creatorUserId, String creationDate) {
          this.id = id;
          this.userId = userId;
          this.password = password;
          this.name = name;
          this.requestTime = requestTime;
          this.role = role;
          this.taggedMerchantIds = taggedMerchantIds;
          this.phoneNumber = phoneNumber;
          this.email = email;
          this.deviceId = deviceId;
          this.installationId = installationId;
          this.rand = rand;
          this.browserAgent = browserAgent;
          this.location = location;
          this.region = region;
          this.area = area;
          this.teritory = teritory;
          this.district = district;
          this.thana = thana;
          this.photo = photo;
          this.onBoardingStatus = onBoardingStatus;
          this.keyAccountManagerId = keyAccountManagerId;
          this.introducerId = introducerId;
          this.attemptId = attemptId;
          this.creatorOrganizationId = creatorOrganizationId;
          this.creatorUserId = creatorUserId;
          this.creationDate = creationDate;
     }

     public String getId() {
          return id;
     }

     public void setId(String id) {
          this.id = id;
     }

     public String getUserId() {
          return userId;
     }

     public void setUserId(String userId) {
          this.userId = userId;
     }

     public String getPassword() {
          return password;
     }

     public void setPassword(String password) {
          this.password = password;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getRequestTime() {
          return requestTime;
     }

     public void setRequestTime(String requestTime) {
          this.requestTime = requestTime;
     }

     public Role[] getRole() {
          return role;
     }

     public void setRole(Role[] role) {
          this.role = role;
     }

     public TaggedMerchantIds[] getTaggedMerchantIds() {
          return taggedMerchantIds;
     }

     public void setTaggedMerchantIds(TaggedMerchantIds[] taggedMerchantIds) {
          this.taggedMerchantIds = taggedMerchantIds;
     }

     public String getPhoneNumber() {
          return phoneNumber;
     }

     public void setPhoneNumber(String phoneNumber) {
          this.phoneNumber = phoneNumber;
     }

     public String getEmail() {
          return email;
     }

     public void setEmail(String email) {
          this.email = email;
     }

     public String getDeviceId() {
          return deviceId;
     }

     public void setDeviceId(String deviceId) {
          this.deviceId = deviceId;
     }

     public String getInstallationId() {
          return installationId;
     }

     public void setInstallationId(String installationId) {
          this.installationId = installationId;
     }

     public String getRand() {
          return rand;
     }

     public void setRand(String rand) {
          this.rand = rand;
     }

     public String getBrowserAgent() {
          return browserAgent;
     }

     public void setBrowserAgent(String browserAgent) {
          this.browserAgent = browserAgent;
     }

     public LocationLongLat getLocation() {
          return location;
     }

     public void setLocation(LocationLongLat location) {
          this.location = location;
     }

     public String getRegion() {
          return region;
     }

     public void setRegion(String region) {
          this.region = region;
     }

     public String getArea() {
          return area;
     }

     public void setArea(String area) {
          this.area = area;
     }

     public String getTeritory() {
          return teritory;
     }

     public void setTeritory(String teritory) {
          this.teritory = teritory;
     }

     public String getDistrict() {
          return district;
     }

     public void setDistrict(String district) {
          this.district = district;
     }

     public String getThana() {
          return thana;
     }

     public void setThana(String thana) {
          this.thana = thana;
     }

     public String getPhoto() {
          return photo;
     }

     public void setPhoto(String photo) {
          this.photo = photo;
     }

     public String getOnBoardingStatus() {
          return onBoardingStatus;
     }

     public void setOnBoardingStatus(String onBoardingStatus) {
          this.onBoardingStatus = onBoardingStatus;
     }

     public String getKeyAccountManagerId() {
          return keyAccountManagerId;
     }

     public void setKeyAccountManagerId(String keyAccountManagerId) {
          this.keyAccountManagerId = keyAccountManagerId;
     }

     public String getIntroducerId() {
          return introducerId;
     }

     public void setIntroducerId(String introducerId) {
          this.introducerId = introducerId;
     }

     public String getAttemptId() {
          return attemptId;
     }

     public void setAttemptId(String attemptId) {
          this.attemptId = attemptId;
     }

     public String getCreatorOrganizationId() {
          return creatorOrganizationId;
     }

     public void setCreatorOrganizationId(String creatorOrganizationId) {
          this.creatorOrganizationId = creatorOrganizationId;
     }

     public String getCreatorUserId() {
          return creatorUserId;
     }

     public void setCreatorUserId(String creatorUserId) {
          this.creatorUserId = creatorUserId;
     }

     public String getCreationDate() {
          return creationDate;
     }

     public void setCreationDate(String creationDate) {
          this.creationDate = creationDate;
     }
}
