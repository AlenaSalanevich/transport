import {BaseComponent} from "./base.component";
import {AppComponent} from "../app.component";
import {PointDataSource} from "../service/point-service/point-data-source";
import {TransportDataSource} from "../service/transport-service/transport-data-source";

export abstract class PageComponent extends BaseComponent {

  constructor() {
    super()
  }

  get minUsernameLength() {
    return AppComponent.MIN_USERNAME_LENGTH;
  }

  get maxUsernameLength() {
    return AppComponent.MAX_USERNAME_LENGTH;
  }

  get minPasswordLength() {
    return AppComponent.MIN_PASSWORD_LENGTH;
  }

  get maxPasswordLength() {
    return AppComponent.MAX_PASSWORD_LENGTH;
  }

  get minPointLenth() {
    return AppComponent.MIN_POINT_LENGTH;
  }

  get maxPointLenth() {
    return AppComponent.MAX_POINT_LENGTH;
  }

  get minTransportTypeLenth() {
    return AppComponent.MIN_TRANSPORT_TYPE_LENGTH
  }

  get maxTransportTypeLenth() {
    return AppComponent.MAX_TRANSPORT_TYPE_LENGTH
  }

  get minRegisterNumber(){
    return AppComponent.MIN_REGISTER_NUMBER_LENGTH}

  get maxRegisterNumber(){
    return AppComponent.MAX_REGISTER_NUMBER_LENGTH}
}

