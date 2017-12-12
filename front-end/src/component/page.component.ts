import {BaseComponent} from "./base.component";
import {AppComponent} from "../app.component";

export abstract class PageComponent extends BaseComponent{

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

get minPointLenth(){
    return AppComponent.MIN_POINT_LENGTH;
}
get maxPointLenth(){
  return AppComponent.MAX_POINT_LENGTH;
}
}
