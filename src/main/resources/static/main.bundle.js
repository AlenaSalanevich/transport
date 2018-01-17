webpackJsonp(["main"],{

/***/ "../../../../../src/$$_lazy_route_resource lazy recursive":
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncatched exception popping up in devtools
	return Promise.resolve().then(function() {
		throw new Error("Cannot find module '" + req + "'.");
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "../../../../../src/$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "../../../../../src/app-routing/app-routing.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppRoutingModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common__ = __webpack_require__("../../../common/esm5/common.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__utils_route_list__ = __webpack_require__("../../../../../src/utils/route-list.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__component_pages_schedule_schedule_component__ = __webpack_require__("../../../../../src/component/pages/schedule/schedule.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__component_pages_login_login_component__ = __webpack_require__("../../../../../src/component/pages/login/login.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__component_pages_point_point_component__ = __webpack_require__("../../../../../src/component/pages/point/point.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__component_pages_route_route_component__ = __webpack_require__("../../../../../src/component/pages/route/route.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__component_pages_transport_transport_component__ = __webpack_require__("../../../../../src/component/pages/transport/transport.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__component_pages_point_add_point_add_point_component__ = __webpack_require__("../../../../../src/component/pages/point/add-point/add-point.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__component_pages_transport_add_transport_add_transport_component__ = __webpack_require__("../../../../../src/component/pages/transport/add-transport/add-transport.component.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};











var routes = [
    { path: '', redirectTo: '/' + __WEBPACK_IMPORTED_MODULE_3__utils_route_list__["a" /* RouteList */].PAGE_SCHEDULE, pathMatch: 'full' },
    { path: __WEBPACK_IMPORTED_MODULE_3__utils_route_list__["a" /* RouteList */].PAGE_SCHEDULE, component: __WEBPACK_IMPORTED_MODULE_4__component_pages_schedule_schedule_component__["a" /* ScheduleComponent */] },
    { path: __WEBPACK_IMPORTED_MODULE_3__utils_route_list__["a" /* RouteList */].PAGE_LOGIN, component: __WEBPACK_IMPORTED_MODULE_5__component_pages_login_login_component__["a" /* LoginComponent */] },
    {
        path: __WEBPACK_IMPORTED_MODULE_3__utils_route_list__["a" /* RouteList */].PAGE_POINT,
        component: __WEBPACK_IMPORTED_MODULE_6__component_pages_point_point_component__["a" /* PointComponent */],
        children: [{ path: __WEBPACK_IMPORTED_MODULE_3__utils_route_list__["a" /* RouteList */].PAGE_ADD_POINT, component: __WEBPACK_IMPORTED_MODULE_9__component_pages_point_add_point_add_point_component__["a" /* AddPointComponent */] }]
    },
    { path: __WEBPACK_IMPORTED_MODULE_3__utils_route_list__["a" /* RouteList */].PAGE_ROUTE, component: __WEBPACK_IMPORTED_MODULE_7__component_pages_route_route_component__["a" /* RouteComponent */] },
    {
        path: __WEBPACK_IMPORTED_MODULE_3__utils_route_list__["a" /* RouteList */].PAGE_TRANSPORT,
        component: __WEBPACK_IMPORTED_MODULE_8__component_pages_transport_transport_component__["a" /* TransportComponent */],
        children: [{ path: __WEBPACK_IMPORTED_MODULE_3__utils_route_list__["a" /* RouteList */].PAGE_ADD_TRANSPORT, component: __WEBPACK_IMPORTED_MODULE_10__component_pages_transport_add_transport_add_transport_component__["a" /* AddTransportComponent */] }]
    }
];
/**
 * The configuration of the router module.
 */
var routerOptions = {
    useHash: true
};
var AppRoutingModule = (function () {
    function AppRoutingModule() {
    }
    AppRoutingModule = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["K" /* NgModule */])({
            imports: [
                __WEBPACK_IMPORTED_MODULE_1__angular_common__["b" /* CommonModule */],
                __WEBPACK_IMPORTED_MODULE_2__angular_router__["b" /* RouterModule */].forRoot(routes, routerOptions)
            ],
            exports: [__WEBPACK_IMPORTED_MODULE_2__angular_router__["b" /* RouterModule */]],
            declarations: []
        })
    ], AppRoutingModule);
    return AppRoutingModule;
}());



/***/ }),

/***/ "../../../../../src/app.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, ".material-icons_text{\r\n  display: block;\r\n  margin: 0;\r\n}\r\n.material-icons{\r\n  margin-top: 3px;\r\n}\r\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app.component.html":
/***/ (function(module, exports) {

module.exports = "<!--The content below is only a placeholder and can be replaced.-->\n<mat-toolbar class=\"app-bar mat-elevation-z6\" color=\"primary\">\n\n  <button mat-button class=\"m-toolbar-button\" routerLink=\"/schedule\" routerLinkActive=\"m-toolbar-button-active\">\n    <mat-icon><i class=\"material-icons\">schedule</i>\n    </mat-icon>\n    <span class = \"material-icons_text\"> Schedule</span>\n  </button>\n\n  <button mat-button class=\"m-toolbar-button\" routerLink=\"/route\"\n          routerLinkActive=\"m-toolbar-button-active\"><mat-icon><i class=\"material-icons\">router</i></mat-icon>\n    <span class = \"material-icons_text\"> Route</span>\n  </button>\n\n  <button mat-button class=\"m-toolbar-button\" routerLink=\"/point\"\n          routerLinkActive=\"m-toolbar-button-active\"><mat-icon><i class=\"material-icons\">store</i></mat-icon>\n    <span class = \"material-icons_text\"> Point</span>\n  </button>\n\n  <button mat-button class=\"m-toolbar-button\" routerLink=\"/transport\"\n          routerLinkActive=\"m-toolbar-button-active\">\n    <mat-icon><i class=\"material-icons\">directions_bus</i></mat-icon>\n    <span class = \"material-icons_text\"> Transport</span>\n  </button>\n\n  <span class=\"app-toolbar-filler\"></span>\n  <button mat-icon-button class=\"m-toolbar-button\" *ngIf=\"!authed\" routerLink=\"/login\"\n          routerLinkActive=\"m-toolbar-button-active\">\n    <mat-icon><i class=\"material-icons\" aria-hidden=\"true\">lock_outline</i></mat-icon>\n  </button>\n  <button mat-button class=\"m-toolbar-button\" *ngIf=\"authed\" routerLink=\"/\" (click)=\"logout()\">\n   <mat-icon> <i class=\"material-icons\">lock_open</i></mat-icon>\n  </button>\n\n</mat-toolbar>\n<div class=\"root-content\">\n  <router-outlet></router-outlet>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__service_security_service_security_service__ = __webpack_require__("../../../../../src/service/security-service/security.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var AppComponent = (function () {
    function AppComponent(security) {
        var _this = this;
        this.security = security;
        this._authed = false;
        this.security.authProperty.subscribe(function (result) { return _this._authed = result; });
    }
    AppComponent.prototype.logout = function () {
        this.security.logout();
    };
    Object.defineProperty(AppComponent.prototype, "authed", {
        /**
         * The flag that the user is authed.
         *
         * @returns {boolean}
         */
        get: function () {
            return this._authed;
        },
        enumerable: true,
        configurable: true
    });
    AppComponent.MIN_USERNAME_LENGTH = 3;
    AppComponent.MAX_USERNAME_LENGTH = 25;
    AppComponent.MIN_PASSWORD_LENGTH = 6;
    AppComponent.MAX_PASSWORD_LENGTH = 25;
    AppComponent.MIN_POINT_LENGTH = 3;
    AppComponent.MAX_POINT_LENGTH = 20;
    AppComponent.MIN_REGISTER_NUMBER_LENGTH = 9;
    AppComponent.MAX_REGISTER_NUMBER_LENGTH = 20;
    AppComponent.MIN_TRANSPORT_TYPE_LENGTH = 3;
    AppComponent.MAX_TRANSPORT_TYPE_LENGTH = 20;
    AppComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-root',
            template: __webpack_require__("../../../../../src/app.component.html"),
            styles: [__webpack_require__("../../../../../src/app.component.css")],
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__service_security_service_security_service__["a" /* SecurityService */]])
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "../../../../../src/app.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__ = __webpack_require__("../../../platform-browser/esm5/platform-browser.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__app_component__ = __webpack_require__("../../../../../src/app.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__component_pages_point_point_component__ = __webpack_require__("../../../../../src/component/pages/point/point.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__component_pages_transport_transport_component__ = __webpack_require__("../../../../../src/component/pages/transport/transport.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__component_pages_route_route_component__ = __webpack_require__("../../../../../src/component/pages/route/route.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__component_pages_schedule_schedule_component__ = __webpack_require__("../../../../../src/component/pages/schedule/schedule.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__component_pages_login_login_component__ = __webpack_require__("../../../../../src/component/pages/login/login.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__angular_forms__ = __webpack_require__("../../../forms/esm5/forms.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__angular_http__ = __webpack_require__("../../../http/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__app_routing_app_routing_module__ = __webpack_require__("../../../../../src/app-routing/app-routing.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11__angular_platform_browser_animations__ = __webpack_require__("../../../platform-browser/esm5/animations.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12__angular_material__ = __webpack_require__("../../../material/esm5/material.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_13__service_security_service_security_service__ = __webpack_require__("../../../../../src/service/security-service/security.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_14__service_transport_service_transport_data_source__ = __webpack_require__("../../../../../src/service/transport-service/transport-data-source.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_15__service_transport_service_transport_service__ = __webpack_require__("../../../../../src/service/transport-service/transport.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_16__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_17__angular_common_http__ = __webpack_require__("../../../common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_18__service_point_service_point_data_source__ = __webpack_require__("../../../../../src/service/point-service/point-data-source.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_19__service_point_service_point_service__ = __webpack_require__("../../../../../src/service/point-service/point.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_20__component_pages_point_add_point_add_point_component__ = __webpack_require__("../../../../../src/component/pages/point/add-point/add-point.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_21__component_pages_transport_add_transport_add_transport_component__ = __webpack_require__("../../../../../src/component/pages/transport/add-transport/add-transport.component.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};






















var AppModule = (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["K" /* NgModule */])({
            declarations: [
                __WEBPACK_IMPORTED_MODULE_2__app_component__["a" /* AppComponent */],
                __WEBPACK_IMPORTED_MODULE_3__component_pages_point_point_component__["a" /* PointComponent */],
                __WEBPACK_IMPORTED_MODULE_4__component_pages_transport_transport_component__["a" /* TransportComponent */],
                __WEBPACK_IMPORTED_MODULE_5__component_pages_route_route_component__["a" /* RouteComponent */],
                __WEBPACK_IMPORTED_MODULE_6__component_pages_schedule_schedule_component__["a" /* ScheduleComponent */],
                __WEBPACK_IMPORTED_MODULE_7__component_pages_login_login_component__["a" /* LoginComponent */],
                __WEBPACK_IMPORTED_MODULE_20__component_pages_point_add_point_add_point_component__["a" /* AddPointComponent */],
                __WEBPACK_IMPORTED_MODULE_21__component_pages_transport_add_transport_add_transport_component__["a" /* AddTransportComponent */],
            ],
            imports: [
                __WEBPACK_IMPORTED_MODULE_8__angular_forms__["d" /* FormsModule */],
                __WEBPACK_IMPORTED_MODULE_9__angular_http__["b" /* HttpModule */],
                __WEBPACK_IMPORTED_MODULE_10__app_routing_app_routing_module__["a" /* AppRoutingModule */],
                __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__["a" /* BrowserModule */],
                __WEBPACK_IMPORTED_MODULE_11__angular_platform_browser_animations__["a" /* BrowserAnimationsModule */],
                __WEBPACK_IMPORTED_MODULE_12__angular_material__["a" /* MatButtonModule */],
                __WEBPACK_IMPORTED_MODULE_12__angular_material__["f" /* MatIconModule */],
                __WEBPACK_IMPORTED_MODULE_12__angular_material__["g" /* MatInputModule */],
                __WEBPACK_IMPORTED_MODULE_12__angular_material__["o" /* MatToolbarModule */],
                __WEBPACK_IMPORTED_MODULE_12__angular_material__["i" /* MatMenuModule */],
                __WEBPACK_IMPORTED_MODULE_12__angular_material__["j" /* MatPaginatorModule */],
                __WEBPACK_IMPORTED_MODULE_12__angular_material__["l" /* MatSidenavModule */],
                __WEBPACK_IMPORTED_MODULE_12__angular_material__["h" /* MatListModule */],
                __WEBPACK_IMPORTED_MODULE_12__angular_material__["e" /* MatGridListModule */],
                __WEBPACK_IMPORTED_MODULE_12__angular_material__["d" /* MatFormFieldModule */],
                __WEBPACK_IMPORTED_MODULE_12__angular_material__["k" /* MatSelectModule */],
                __WEBPACK_IMPORTED_MODULE_16__angular_router__["b" /* RouterModule */],
                __WEBPACK_IMPORTED_MODULE_12__angular_material__["n" /* MatTabsModule */],
                __WEBPACK_IMPORTED_MODULE_12__angular_material__["m" /* MatTableModule */],
                __WEBPACK_IMPORTED_MODULE_17__angular_common_http__["b" /* HttpClientModule */],
                __WEBPACK_IMPORTED_MODULE_12__angular_material__["b" /* MatCardModule */],
                __WEBPACK_IMPORTED_MODULE_12__angular_material__["p" /* MatTooltipModule */],
                __WEBPACK_IMPORTED_MODULE_8__angular_forms__["i" /* ReactiveFormsModule */],
                __WEBPACK_IMPORTED_MODULE_12__angular_material__["c" /* MatCheckboxModule */],
                __WEBPACK_IMPORTED_MODULE_12__angular_material__["l" /* MatSidenavModule */]
            ],
            providers: [__WEBPACK_IMPORTED_MODULE_13__service_security_service_security_service__["a" /* SecurityService */], __WEBPACK_IMPORTED_MODULE_14__service_transport_service_transport_data_source__["a" /* TransportDataSource */], __WEBPACK_IMPORTED_MODULE_15__service_transport_service_transport_service__["a" /* TransportService */], __WEBPACK_IMPORTED_MODULE_18__service_point_service_point_data_source__["a" /* PointDataSource */], __WEBPACK_IMPORTED_MODULE_19__service_point_service_point_service__["a" /* PointService */]],
            bootstrap: [__WEBPACK_IMPORTED_MODULE_2__app_component__["a" /* AppComponent */]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "../../../../../src/component/base.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return BaseComponent; });
var BaseComponent = (function () {
    function BaseComponent() {
    }
    BaseComponent.prototype.ngOnInit = function () {
    };
    return BaseComponent;
}());



/***/ }),

/***/ "../../../../../src/component/page.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return PageComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__base_component__ = __webpack_require__("../../../../../src/component/base.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__app_component__ = __webpack_require__("../../../../../src/app.component.ts");
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();


var PageComponent = (function (_super) {
    __extends(PageComponent, _super);
    function PageComponent() {
        return _super.call(this) || this;
    }
    Object.defineProperty(PageComponent.prototype, "minUsernameLength", {
        get: function () {
            return __WEBPACK_IMPORTED_MODULE_1__app_component__["a" /* AppComponent */].MIN_USERNAME_LENGTH;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(PageComponent.prototype, "maxUsernameLength", {
        get: function () {
            return __WEBPACK_IMPORTED_MODULE_1__app_component__["a" /* AppComponent */].MAX_USERNAME_LENGTH;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(PageComponent.prototype, "minPasswordLength", {
        get: function () {
            return __WEBPACK_IMPORTED_MODULE_1__app_component__["a" /* AppComponent */].MIN_PASSWORD_LENGTH;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(PageComponent.prototype, "maxPasswordLength", {
        get: function () {
            return __WEBPACK_IMPORTED_MODULE_1__app_component__["a" /* AppComponent */].MAX_PASSWORD_LENGTH;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(PageComponent.prototype, "minPointLenth", {
        get: function () {
            return __WEBPACK_IMPORTED_MODULE_1__app_component__["a" /* AppComponent */].MIN_POINT_LENGTH;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(PageComponent.prototype, "maxPointLenth", {
        get: function () {
            return __WEBPACK_IMPORTED_MODULE_1__app_component__["a" /* AppComponent */].MAX_POINT_LENGTH;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(PageComponent.prototype, "minTransportTypeLenth", {
        get: function () {
            return __WEBPACK_IMPORTED_MODULE_1__app_component__["a" /* AppComponent */].MIN_TRANSPORT_TYPE_LENGTH;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(PageComponent.prototype, "maxTransportTypeLenth", {
        get: function () {
            return __WEBPACK_IMPORTED_MODULE_1__app_component__["a" /* AppComponent */].MAX_TRANSPORT_TYPE_LENGTH;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(PageComponent.prototype, "minRegisterNumber", {
        get: function () {
            return __WEBPACK_IMPORTED_MODULE_1__app_component__["a" /* AppComponent */].MIN_REGISTER_NUMBER_LENGTH;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(PageComponent.prototype, "maxRegisterNumber", {
        get: function () {
            return __WEBPACK_IMPORTED_MODULE_1__app_component__["a" /* AppComponent */].MAX_REGISTER_NUMBER_LENGTH;
        },
        enumerable: true,
        configurable: true
    });
    return PageComponent;
}(__WEBPACK_IMPORTED_MODULE_0__base_component__["a" /* BaseComponent */]));



/***/ }),

/***/ "../../../../../src/component/pages/login/login.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, ".login-form-container {\r\n  width: 400px;\r\n  margin: 0 auto;\r\n  margin-top: 64px;\r\n}\r\n\r\n.login-form {\r\n}\r\n\r\n.login-data-form {\r\n  border-collapse: collapse;\r\n  border-radius: 2px;\r\n  border-spacing: 0px;\r\n  padding: 10px;\r\n  background-color: white;\r\n}\r\n\r\n.login-data-row {\r\n  width: 100%;\r\n  display: block;\r\n  margin-top: 40px;\r\n  margin-bottom: 20px;\r\n}\r\n\r\n.login-button {\r\n  width: 100%;\r\n}\r\n\r\n.login-page-title {\r\n  color: #636363;\r\n  text-align: center;\r\n}\r\n\r\n.login-page-error {\r\n  color: #ff002b;\r\n  text-align: center;\r\n  margin-top: 10px;\r\n}\r\n\r\n.login-text-container {\r\n  margin-bottom: 50px;\r\n  margin-top: 10px;\r\n}\r\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/component/pages/login/login.component.html":
/***/ (function(module, exports) {

module.exports = "\n<div class=\"login-form-container\">\n  <div class=\"login-form\">\n\n    <div class=\"login-text-container\">\n      <h2 class=\"login-page-title\">Authentication</h2>\n      <h3 class=\"login-page-error\" [hidden]=\"error.length == 0\">\n        {{error}}\n      </h3>\n    </div>\n\n    <form class=\"login-data-form mat-elevation-z2\" (ngSubmit)=\"tryAuth()\" #userForm=\"ngForm\">\n      <mat-input-container class=\"login-data-row\">\n        <input matInput placeholder=\"Username\" id=\"username\" required minlength=\"{{minUsernameLength}}\"\n               maxlength=\"{{maxUsernameLength}}\"\n               [(ngModel)]=\"credentials.login\" name=\"name\"\n               #name=\"ngModel\">\n      </mat-input-container>\n      <mat-input-container class=\"login-data-row\">\n        <input matInput placeholder=\"Password\" type=\"password\" id=\"password\" required minlength=\"{{minPasswordLength}}\"\n               maxlength=\"{{maxPasswordLength}}\"\n               [(ngModel)]=\"credentials.password\"\n               name=\"password\"\n               #password=\"ngModel\">\n      </mat-input-container>\n      <button class=\"login-data-row login-button\" mat-raised-button color=\"primary\"\n              [disabled]=\"!userForm.form.valid\">Login\n      </button>\n    </form>\n  </div>\n</div>\n"

/***/ }),

/***/ "../../../../../src/component/pages/login/login.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return LoginComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__page_component__ = __webpack_require__("../../../../../src/component/page.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__model_user_user_credentials__ = __webpack_require__("../../../../../src/model/user/user-credentials.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__service_security_service_security_service__ = __webpack_require__("../../../../../src/service/security-service/security.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var LoginComponent = (function (_super) {
    __extends(LoginComponent, _super);
    function LoginComponent(security, router) {
        var _this = _super.call(this) || this;
        _this.security = security;
        _this.router = router;
        _this.credentials = new __WEBPACK_IMPORTED_MODULE_2__model_user_user_credentials__["a" /* UserCredentials */]('', '');
        _this.error = '';
        return _this;
    }
    LoginComponent.prototype.tryAuth = function () {
        var _this = this;
        this.security.auth(this.credentials, function (message, result) {
            if (result) {
                _this.error = '';
                _this.credentials.login = '';
                _this.credentials.password = '';
                _this.router.navigateByUrl('/');
            }
            else {
                _this.error = message;
            }
        });
    };
    LoginComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-login',
            template: __webpack_require__("../../../../../src/component/pages/login/login.component.html"),
            styles: [__webpack_require__("../../../../../src/component/pages/login/login.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_3__service_security_service_security_service__["a" /* SecurityService */], __WEBPACK_IMPORTED_MODULE_4__angular_router__["a" /* Router */]])
    ], LoginComponent);
    return LoginComponent;
}(__WEBPACK_IMPORTED_MODULE_1__page_component__["a" /* PageComponent */]));



/***/ }),

/***/ "../../../../../src/component/pages/point/add-point/add-point.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, ".add-point-form-container {\r\n  margin-left: 10%;\r\n  margin-top: 3%;\r\nwidth: -webkit-max-content;\r\nwidth: -moz-max-content;\r\nwidth: max-content;\r\n}\r\n\r\n.add-point-form {\r\n}\r\n\r\n.add-point-data-form {\r\n  border-collapse: collapse;\r\n  border-radius: 2px;\r\n  border-spacing: 0px;\r\n  padding: 10px;\r\n  background-color: white;\r\n}\r\n\r\n.add-point-data-row {\r\n  width: 100%;\r\n  display: block;\r\n  margin-top: 40px;\r\n  margin-bottom: 20px;\r\n}\r\n\r\n.add-point-button {\r\n  width: 100%;\r\n  margin-bottom: 5px;\r\n}\r\n\r\n.add-point-buttons {\r\n  -webkit-box-orient: vertical;\r\n  -webkit-box-direction: normal;\r\n      -ms-flex-direction: column;\r\n          flex-direction: column;\r\n  display: -webkit-box;\r\n  display: -ms-flexbox;\r\n  display: flex;\r\n}\r\n\r\n.add-point-page-title {\r\n  color: #636363;\r\n  text-align: center;\r\n}\r\n\r\n.add-point-page-error {\r\n  color: #ff002b;\r\n  text-align: center;\r\n  margin-top: 10px;\r\n}\r\n\r\n.add-point-text-container {\r\n  margin-bottom: 30px;\r\n  margin-top: 10px;\r\n  font-size: small;\r\n}\r\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/component/pages/point/add-point/add-point.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"add-point-form-container\">\n  <div class=\"add-point-form\">\n    <form class=\"add-point-data-form mat-elevation-z2\" (ngSubmit)=\"tryCreatePoint()\" #createForm=\"ngForm\">\n      <div class=\"add-point-text-container\">\n        <h2 class=\"add-point-page-title\">Add new point</h2>\n        <h3 class=\"add-point-page-error\" [hidden]=\"error.length == 0\">\n          {{error}}\n        </h3>\n      </div>\n      <mat-input-container class=\"add-point-data-row\">\n        <input matInput placeholder=\"Name of point\" id=\"name\" required minlength=\"{{minPointLenth}}\"\n               maxlength=\"{{maxPointLenth}}\"\n               [(ngModel)]=\"pointInfo.name\" name=\"name\"\n               #name=\"ngModel\">\n      </mat-input-container>\n\n      <div class=\"add-point-buttons\">\n        <button class=\"add-point-button\" type=\"submit\" mat-raised-button color=\"primary\"\n                [disabled]=\"!createForm.form.valid\"> Add point\n        </button>\n        <button class=\"add-point-button\" type=\"submit\" mat-raised-button color=\"primary\"\n                (click)=\"redirectToPoints()\"> Cancel\n        </button>\n      </div>\n    </form>\n  </div>\n</div>\n"

/***/ }),

/***/ "../../../../../src/component/pages/point/add-point/add-point.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AddPointComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__page_component__ = __webpack_require__("../../../../../src/component/page.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__model_point_point_params__ = __webpack_require__("../../../../../src/model/point/point-params.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__service_point_service_point_service__ = __webpack_require__("../../../../../src/service/point-service/point.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__service_point_service_point_data_source__ = __webpack_require__("../../../../../src/service/point-service/point-data-source.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__utils_route_list__ = __webpack_require__("../../../../../src/utils/route-list.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__point_component__ = __webpack_require__("../../../../../src/component/pages/point/point.component.ts");
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};








var AddPointComponent = (function (_super) {
    __extends(AddPointComponent, _super);
    function AddPointComponent(pointService, router, pointComponent) {
        var _this = _super.call(this) || this;
        _this.pointService = pointService;
        _this.router = router;
        _this.pointComponent = pointComponent;
        _this._pointInfo = new __WEBPACK_IMPORTED_MODULE_2__model_point_point_params__["a" /* PointParams */]('');
        _this._error = '';
        return _this;
    }
    AddPointComponent.prototype.tryCreatePoint = function () {
        var _this = this;
        this.pointService.createPoint(this._pointInfo, function (message, result) {
            if (result) {
                var pointInfo = _this.pointInfo;
                pointInfo.name = '';
                _this._error = '';
                _this.pointService.loadPoints();
                _this.redirectToPoints();
                _this.pointService.loadPoints();
            }
            else {
                _this._error = message;
            }
            _this.pointService.loadPoints();
        });
    };
    AddPointComponent.prototype.redirectToPoints = function () {
        this.router.navigateByUrl('/' + __WEBPACK_IMPORTED_MODULE_6__utils_route_list__["a" /* RouteList */].PAGE_POINT);
        this.pointComponent.ngOnInit();
    };
    Object.defineProperty(AddPointComponent.prototype, "pointInfo", {
        get: function () {
            return this._pointInfo;
        },
        set: function (value) {
            this._pointInfo = value;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(AddPointComponent.prototype, "error", {
        get: function () {
            return this._error;
        },
        set: function (value) {
            this._error = value;
        },
        enumerable: true,
        configurable: true
    });
    AddPointComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-add-point',
            template: __webpack_require__("../../../../../src/component/pages/point/add-point/add-point.component.html"),
            styles: [__webpack_require__("../../../../../src/component/pages/point/add-point/add-point.component.css")],
            providers: [__WEBPACK_IMPORTED_MODULE_4__service_point_service_point_data_source__["a" /* PointDataSource */], __WEBPACK_IMPORTED_MODULE_3__service_point_service_point_service__["a" /* PointService */]]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_3__service_point_service_point_service__["a" /* PointService */],
            __WEBPACK_IMPORTED_MODULE_5__angular_router__["a" /* Router */], __WEBPACK_IMPORTED_MODULE_7__point_component__["a" /* PointComponent */]])
    ], AddPointComponent);
    return AddPointComponent;
}(__WEBPACK_IMPORTED_MODULE_1__page_component__["a" /* PageComponent */]));



/***/ }),

/***/ "../../../../../src/component/pages/point/point.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, ".material-icons.blue{\r\n  color: #3f51b5;\r\n  font-size: 48px;\r\n}\r\n.material-icons.grey{\r\n  color: lightgrey;\r\n}\r\n\r\n.material-icons-text{\r\n  font-size: 10px;\r\n  font-weight: bold;\r\n  color: #3f51b5;\r\n}\r\n\r\n.mat-icon-button {\r\n  position: fixed;\r\n  right: 5%;\r\n  bottom: 5%;\r\n}\r\n.search-button {\r\n  display: -webkit-box;\r\n  display: -ms-flexbox;\r\n  display: flex;\r\n  -webkit-box-orient: horizontal;\r\n  -webkit-box-direction: reverse;\r\n      -ms-flex-direction: row-reverse;\r\n          flex-direction: row-reverse;\r\n}\r\n.add-point-button-position {\r\n  position: absolute;\r\n  float: right;\r\n  z-index: 10;\r\n}\r\n\r\n.form-point {\r\n  position: absolute;\r\n  height:inherit;\r\n  width: -webkit-max-content;\r\n  width: -moz-max-content;\r\n  width: max-content;\r\n  -ms-flex-item-align: center;\r\n      -ms-grid-row-align: center;\r\n      align-self: center;\r\n  margin-top: initial;\r\n}\r\n\r\n.point-content {\r\n  position: absolute;\r\n  width: 81.5%;\r\n  color: #636363;\r\n  font-family: inherit;\r\n}\r\n\r\n.card {\r\n  float: left;\r\n  margin: 10px;\r\n  position: relative;\r\n  width: 100px;\r\n}\r\n.mat-button{\r\n}\r\n.mat-card-actions {\r\n  display: -webkit-box;\r\n  display: -ms-flexbox;\r\n  display: flex;\r\n  -webkit-box-orient: horizontal;\r\n  -webkit-box-direction: reverse;\r\n      -ms-flex-direction: row-reverse;\r\n          flex-direction: row-reverse;\r\n}\r\n.mat-card-content{\r\n  font-family: Roboto, \"Helvetica Neue\", sans-serif;\r\n  font-size: medium;\r\n  font-weight: bold;\r\n  color: #3f51b5;\r\n  text-align: center;\r\n}\r\n\r\n.mat-icon-button-card-actions {\r\nposition: relative;\r\n}\r\n.mat-icon-button-card-actions:hover {\r\n  color: grey;\r\n}\r\n\r\n.mat-paginator {\r\n  position: relative;\r\n\r\n\r\n}\r\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/component/pages/point/point.component.html":
/***/ (function(module, exports) {

module.exports = "<!-- Search button (initiates search) -->\r\n<div class=\"search-button\" matTooltip=\"Search point\" aria-hidden=\"true\" tooltip-position=\"left\">\r\n  <button mat-button class=\"m-toolbar-button\">\r\n    <mat-icon><i class=\"material-icons md 12 blue\">search</i></mat-icon>\r\n    <span class=\"material-icons-text\">Search</span>\r\n  </button>\r\n</div>\r\n\r\n<!--&lt;!&ndash; Search bar &ndash;&gt;\r\n<div class=\"mat-toolbar\" >\r\n  <button class=\"mat-icon-button\" >\r\n    <mat-icon> <i class=\"material-icons md 24 blue\">search</i> </mat-icon>\r\n  </button>\r\n\r\n  &lt;!&ndash; Input Text &ndash;&gt;\r\n  <mat-input-container flex>\r\n    &lt;!&ndash; <label for=\"search\">Search</label> &ndash;&gt;\r\n    <input  type=\"text\"  />\r\n  </mat-input-container>\r\n\r\n  &lt;!&ndash; Close search bar &ndash;&gt;\r\n  <button class=\"md-icon-button\" >\r\n    <mat-icon><i class=\"material-icons\">close</i></mat-icon>\r\n  </button>\r\n</div>height=\"90\" width=\"144\"\r\n\r\n <button mat-button class=\"add-point-button\" type=\"submit\" mat-raised-button color=\"primary\">Edit</button>\r\n\r\n-->\r\n\r\n<div class=\"points\">\r\n  <div *ngFor=\"let point of points\">\r\n    <mat-card class=\"card\">\r\n      <mat-card-header>\r\n        <mat-card-title></mat-card-title>\r\n        <mat-card-subtitle></mat-card-subtitle>\r\n      </mat-card-header>\r\n\r\n      <img mat-card-image src=\"../../../assets/point.png\"/>\r\n      <mat-card-content>\r\n        {{point.name}}\r\n      </mat-card-content>\r\n      <mat-card-actions>\r\n\r\n        <button mat-icon-button class=\"mat-icon-button-card-actions\">\r\n          <mat-icon><i class=\"material-icons md-24 grey\" aria-hidden=\"true\" (click)=\"onDeleteSelect(point)\">delete</i></mat-icon>\r\n        </button>\r\n\r\n        <button mat-icon-button class=\"mat-icon-button-card-actions\">\r\n          <mat-icon><i class=\"material-icons md-24 grey\" aria-hidden=\"true\" (click)=\"onEditSelect(point)\">mode_edit</i></mat-icon>\r\n        </button>\r\n\r\n      </mat-card-actions>\r\n    </mat-card>\r\n  </div>\r\n</div>\r\n\r\n\r\n<div class=\"add-point-form-container\" *ngIf=\"editSelectedPoint\">\r\n  <div class=\"add-point-form\">\r\n    <form class=\"add-point-data-form mat-elevation-z2\" (ngSubmit)=\"tryUpdatePoint()\" #createForm=\"ngForm\">\r\n  <h2> DETAILS: {{ editSelectedPoint.name | uppercase }} </h2>\r\n      <h3 class=\"add-point-page-error\" [hidden]=\"error.length == 0\">\r\n        {{error}}\r\n      </h3>\r\n  <div>\r\n    <mat-input-container class=\"add-point-data-row\">\r\n      <input matInput placeholder=\"The point name\" id=\"name\" required\r\n             minlength=\"{{minPointLenth}}\"\r\n             maxlength=\"{{maxPointLenth}}\"\r\n             [(ngModel)]=\"pointInfo.name\" name=\"name\"\r\n             #name=\"ngModel\">\r\n    </mat-input-container>\r\n  </div>\r\n\r\n\r\n  <div class=\"add-point-buttons\">\r\n    <button class=\"add-point-button\" type=\"submit\" mat-raised-button color=\"primary\"\r\n            [disabled]=\"!createForm.form.valid\"> Update point\r\n    </button>\r\n    <button class=\"add-point-button\" type=\"submit\" mat-raised-button color=\"primary\"\r\n            (click)=\"redirectToPoints()\"> Cancel\r\n    </button>\r\n  </div>\r\n    </form>\r\n  </div>\r\n</div>\r\n\r\n<div class=\"add-point-form-container\" *ngIf=\"deleteSelectedPoint\">\r\n  <div class=\"add-point-form\">\r\n    <form class=\"add-point-data-form mat-elevation-z2\">\r\n  <h2>DELETE{{ deleteSelectedPoint.name | uppercase }} </h2>\r\n  <h3 class=\"add-point-page-error\" [hidden]=\"error.length == 0\">\r\n    {{error}}\r\n  </h3>\r\n  <p> Are you sure to delete this point?</p>\r\n\r\n  <div class=\"add-point-buttons\">\r\n    <button class=\"add-point-button\" type=\"submit\" mat-raised-button color=\"primary\"\r\n            (click)=\"tryDeletePoint()\"> Delete point\r\n    </button>\r\n    <button class=\"add-point-button\" type=\"submit\" mat-raised-button color=\"primary\"\r\n            (click)=\"redirectToPoints()\"> Cancel\r\n    </button>\r\n  </div>\r\n    </form>\r\n  </div>\r\n</div>\r\n\r\n<div class=\"add-point-button-position\">\r\n  <div class=\"mat-icon-button\" matTooltip=\"Add point\">\r\n    <button mat-icon-button [routerLink]=\"['./add'] \">\r\n      <mat-icon><i class=\"material-icons md-48 blue\" aria-hidden=\"true\">add_circle</i></mat-icon>\r\n    </button>\r\n  </div>\r\n</div>\r\n\r\n<mat-paginator\r\n  [length]=\"setLength\"\r\n               [pageSize]=\"30\"\r\n               [pageSizeOptions]=\"[30, 60]\">\r\n</mat-paginator>\r\n\r\n<div class=\"form-point\">\r\n  <router-outlet></router-outlet>\r\n</div>\r\n\r\n\r\n\r\n\r\n"

/***/ }),

/***/ "../../../../../src/component/pages/point/point.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return PointComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__page_component__ = __webpack_require__("../../../../../src/component/page.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__service_point_service_point_data_source__ = __webpack_require__("../../../../../src/service/point-service/point-data-source.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_rxjs_add_observable_of__ = __webpack_require__("../../../../rxjs/_esm5/add/observable/of.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__service_point_service_point_service__ = __webpack_require__("../../../../../src/service/point-service/point.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__utils_route_list__ = __webpack_require__("../../../../../src/utils/route-list.ts");
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};







var PointComponent = (function (_super) {
    __extends(PointComponent, _super);
    function PointComponent(pointService, router) {
        var _this = _super.call(this) || this;
        _this.pointService = pointService;
        _this.router = router;
        _this.loadPoints();
        _this.setLength();
        return _this;
    }
    PointComponent.prototype.ngOnInit = function () {
        this.loadPoints();
        this.setLength();
    };
    PointComponent.prototype.loadPoints = function () {
        var _this = this;
        this.pointService.loadPoints()
            .then(function (value) { return _this._points = value; });
    };
    PointComponent.prototype.tryDeletePoint = function () {
        var _this = this;
        this.pointService.deletePoint(this._pointInfo, function (message, result) {
            if (result) {
                _this.pointService.loadPoints();
                _this.ngOnInit();
            }
            else {
                _this._error = message;
            }
            _this.loadPoints();
        });
    };
    PointComponent.prototype.tryUpdatePoint = function () {
        var _this = this;
        this.pointService.updatePoint(this._pointInfo, function (message, result) {
            if (result) {
                _this.pointService.loadPoints();
                _this.redirectToPoints();
            }
            else {
                _this._error = message;
            }
            _this.pointService.loadPoints();
        });
    };
    PointComponent.prototype.redirectToPoints = function () {
        this.router.navigateByUrl('/' + __WEBPACK_IMPORTED_MODULE_6__utils_route_list__["a" /* RouteList */].PAGE_POINT);
        this.ngOnInit();
    };
    PointComponent.prototype.onEditSelect = function (point) {
        this._editSelectedPoint = point;
        this._pointInfo = this._editSelectedPoint;
        this._error = '';
    };
    PointComponent.prototype.onDeleteSelect = function (point) {
        this._deleteSelectedPoint = point;
        this._pointInfo = this._deleteSelectedPoint;
        this._error = '';
    };
    Object.defineProperty(PointComponent.prototype, "length", {
        get: function () {
            return this._length;
        },
        enumerable: true,
        configurable: true
    });
    PointComponent.prototype.setLength = function () {
        this._length = this._points.length;
    };
    Object.defineProperty(PointComponent.prototype, "deleteSelectedPoint", {
        get: function () {
            return this._deleteSelectedPoint;
        },
        set: function (value) {
            this._deleteSelectedPoint = value;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(PointComponent.prototype, "editSelectedPoint", {
        get: function () {
            return this._editSelectedPoint;
        },
        set: function (value) {
            this._editSelectedPoint = value;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(PointComponent.prototype, "pointInfo", {
        get: function () {
            return this._pointInfo;
        },
        set: function (value) {
            this._pointInfo = value;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(PointComponent.prototype, "error", {
        get: function () {
            return this._error;
        },
        set: function (value) {
            this._error = value;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(PointComponent.prototype, "points", {
        get: function () {
            return this._points;
        },
        set: function (value) {
            this._points = value;
        },
        enumerable: true,
        configurable: true
    });
    PointComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-point',
            template: __webpack_require__("../../../../../src/component/pages/point/point.component.html"),
            styles: [__webpack_require__("../../../../../src/component/pages/point/point.component.css")],
            encapsulation: __WEBPACK_IMPORTED_MODULE_0__angular_core__["_14" /* ViewEncapsulation */].Emulated,
            preserveWhitespaces: true,
            providers: [__WEBPACK_IMPORTED_MODULE_2__service_point_service_point_data_source__["a" /* PointDataSource */]]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_5__service_point_service_point_service__["a" /* PointService */],
            __WEBPACK_IMPORTED_MODULE_4__angular_router__["a" /* Router */]])
    ], PointComponent);
    return PointComponent;
}(__WEBPACK_IMPORTED_MODULE_1__page_component__["a" /* PageComponent */]));



/***/ }),

/***/ "../../../../../src/component/pages/route/route.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, ".mat-image{\r\n  position: fixed;\r\n}\r\n.image{\r\n   width: 100%;\r\n  height: inherit;\r\n  overflow-y: scroll;\r\n  position: inherit;\r\n}\r\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/component/pages/route/route.component.html":
/***/ (function(module, exports) {

module.exports = "\r\n<div class=\"mat-image\">\r\n  <img class=\"image\" src=\"../../../assets/294.jpg\" />\r\n</div>\r\n\r\n"

/***/ }),

/***/ "../../../../../src/component/pages/route/route.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return RouteComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__page_component__ = __webpack_require__("../../../../../src/component/page.component.ts");
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var RouteComponent = (function (_super) {
    __extends(RouteComponent, _super);
    function RouteComponent() {
        return _super.call(this) || this;
    }
    RouteComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-route',
            template: __webpack_require__("../../../../../src/component/pages/route/route.component.html"),
            styles: [__webpack_require__("../../../../../src/component/pages/route/route.component.css")]
        }),
        __metadata("design:paramtypes", [])
    ], RouteComponent);
    return RouteComponent;
}(__WEBPACK_IMPORTED_MODULE_1__page_component__["a" /* PageComponent */]));



/***/ }),

/***/ "../../../../../src/component/pages/schedule/schedule.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, ".mat-image{\r\n  position: fixed;\r\n}\r\n.image{\r\n  width: 100%;\r\n  height: inherit;\r\n  overflow-y: scroll;\r\n  position: inherit;\r\n}\r\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/component/pages/schedule/schedule.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"mat-image\">\r\n  <img src=\"../../../assets/Untitled-1-01.jpg\"/>\r\n  </div>\r\n"

/***/ }),

/***/ "../../../../../src/component/pages/schedule/schedule.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ScheduleComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__page_component__ = __webpack_require__("../../../../../src/component/page.component.ts");
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var ScheduleComponent = (function (_super) {
    __extends(ScheduleComponent, _super);
    function ScheduleComponent() {
        return _super.call(this) || this;
    }
    ScheduleComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-schedule',
            template: __webpack_require__("../../../../../src/component/pages/schedule/schedule.component.html"),
            styles: [__webpack_require__("../../../../../src/component/pages/schedule/schedule.component.css")]
        }),
        __metadata("design:paramtypes", [])
    ], ScheduleComponent);
    return ScheduleComponent;
}(__WEBPACK_IMPORTED_MODULE_1__page_component__["a" /* PageComponent */]));



/***/ }),

/***/ "../../../../../src/component/pages/transport/add-transport/add-transport.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, ".add-point-form-container {\r\n  margin-left: 40%;\r\n  margin-top: 3%;\r\n  width: -webkit-max-content;\r\n  width: -moz-max-content;\r\n  width: max-content;\r\n}\r\n\r\n\r\n.add-point-form {\r\n  width: 100%\r\n}\r\n\r\n.add-point-data-form {\r\n  border-collapse: collapse;\r\n  border-radius: 2px;\r\n  border-spacing: 0px;\r\n  padding: 10px;\r\n  background-color: white;\r\n}\r\n\r\n.add-point-data-row {\r\n  width: 100%;\r\n  display: block;\r\n  margin-top: 40px;\r\n  margin-bottom: 20px;\r\n}\r\n\r\n.add-point-button {\r\n  width: 100%;\r\n  margin-bottom: 5px;\r\n}\r\n\r\n.add-point-buttons {\r\n  -webkit-box-orient: vertical;\r\n  -webkit-box-direction: normal;\r\n      -ms-flex-direction: column;\r\n          flex-direction: column;\r\n  display: -webkit-box;\r\n  display: -ms-flexbox;\r\n  display: flex;\r\n}\r\n\r\n.add-point-page-title {\r\n  color: #636363;\r\n  text-align: center;\r\n}\r\n\r\n.add-point-page-error {\r\n  color: #ff002b;\r\n  text-align: center;\r\n  margin-top: 10px;\r\n}\r\n\r\n.add-point-text-container {\r\n  margin-bottom: 30px;\r\n  margin-top: 10px;\r\n}\r\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/component/pages/transport/add-transport/add-transport.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"add-point-form-container\">\n  <div class=\"add-point-form\">\n    <form class=\"add-point-data-form mat-elevation-z2\" (ngSubmit)=\"tryCreateTransport()\" #createForm=\"ngForm\">\n      <div class=\"add-point-text-container\">\n        <h2 class=\"add-point-page-title\">Add new transport</h2>\n        <h3 class=\"add-point-page-error\" [hidden]=\"error.length == 0\">\n          {{error}}\n        </h3>\n      </div>\n      <mat-input-container class=\"add-point-data-row\">\n        <input matInput placeholder=\"Transport register number\" id=\"registrationNumber\" required\n               minlength=\"{{minRegisterNumber}}\"\n               maxlength=\"{{maxRegisterNumber}}\"\n               [(ngModel)]=\"transportInfo.registrationNumber\" name=\"registrationNumber\"\n               #name=\"ngModel\">\n      </mat-input-container>\n\n      <mat-input-container>\n        <mat-select placeholder=\"Transport type\" [formControl]=\"transportTypeControl\" required [(ngModel)]=\"selectedTransportType\"   name=\"transportType\">\n          <mat-option *ngFor=\"let transportType of availableTransportTypes\" [value]=\"transportType.value\">\n            {{ transportType.viewValue }}\n          </mat-option>\n        </mat-select>\n        <mat-error *ngIf=\"transportTypeControl.hasError('required')\">Please choose a transport type</mat-error>\n      </mat-input-container>\n\n      <mat-input-container>\n        <mat-select placeholder=\"Transport functionality\" [(ngModel)]=\"selectedTransportFunctionality\" required\n                    true name=\"functionality\">\n          <mat-option *ngFor=\"let functionality of _availableTransportFunctionality\" [value]=\"functionality.value\">\n            {{ functionality.viewValue }}\n          </mat-option>\n        </mat-select>\n      </mat-input-container>\n\n      <div class=\"add-point-buttons\">\n        <button class=\"add-point-button\" type=\"submit\" mat-raised-button color=\"primary\"\n                [disabled]=\"!createForm.form.valid\"> Add transport\n        </button>\n        <button class=\"add-point-button\" type=\"submit\" mat-raised-button color=\"primary\"\n                (click)=\"redirectToTransports()\"> Cancel\n        </button>\n      </div>\n    </form>\n  </div>\n</div>\n"

/***/ }),

/***/ "../../../../../src/component/pages/transport/add-transport/add-transport.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AddTransportComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__service_transport_service_transport_data_source__ = __webpack_require__("../../../../../src/service/transport-service/transport-data-source.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__service_transport_service_transport_service__ = __webpack_require__("../../../../../src/service/transport-service/transport.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__page_component__ = __webpack_require__("../../../../../src/component/page.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__model_transport_transport_params__ = __webpack_require__("../../../../../src/model/transport/transport-params.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__utils_route_list__ = __webpack_require__("../../../../../src/utils/route-list.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__angular_forms__ = __webpack_require__("../../../forms/esm5/forms.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__transport_component__ = __webpack_require__("../../../../../src/component/pages/transport/transport.component.ts");
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};









var AddTransportComponent = (function (_super) {
    __extends(AddTransportComponent, _super);
    function AddTransportComponent(transportService, router, transportComponent) {
        var _this = _super.call(this) || this;
        _this.transportService = transportService;
        _this.router = router;
        _this.transportComponent = transportComponent;
        _this.transportTypeControl = new __WEBPACK_IMPORTED_MODULE_7__angular_forms__["b" /* FormControl */]('', [__WEBPACK_IMPORTED_MODULE_7__angular_forms__["j" /* Validators */].required]);
        _this._availableTransportTypes = [
            { value: __WEBPACK_IMPORTED_MODULE_2__service_transport_service_transport_service__["a" /* TransportService */].TRANSPORT_TYPE_BUS, viewValue: 'BUS' },
            { value: __WEBPACK_IMPORTED_MODULE_2__service_transport_service_transport_service__["a" /* TransportService */].TRANSPORT_TYPE_TRAM, viewValue: 'TRAM' },
            { value: __WEBPACK_IMPORTED_MODULE_2__service_transport_service_transport_service__["a" /* TransportService */].TRANSPORT_TYPE_TROLLEYBUS, viewValue: 'TROLLEYBUS' }
        ];
        _this._availableTransportFunctionality = [
            { value: __WEBPACK_IMPORTED_MODULE_2__service_transport_service_transport_service__["a" /* TransportService */].TRANSPORT_FUNCTIONALITY_WORKING, viewValue: "FUNCTIONALLY" },
            { value: __WEBPACK_IMPORTED_MODULE_2__service_transport_service_transport_service__["a" /* TransportService */].TRANSPORT_FUNCTIONALITY_BROKEN, viewValue: "NO FUNCTIONALLY" }
        ];
        _this._transportInfo = new __WEBPACK_IMPORTED_MODULE_4__model_transport_transport_params__["a" /* TransportParams */]('', '', true);
        _this._error = '';
        return _this;
    }
    AddTransportComponent.prototype.tryCreateTransport = function () {
        var _this = this;
        this.setTransportType();
        this.setTransportFunctionality();
        this.transportService.createTransport(this._transportInfo, function (message, result) {
            if (result) {
                var transportInfo = _this.transportInfo;
                transportInfo.registrationNumber = '';
                _this.transportService.loadTransports();
                _this.redirectToTransports();
            }
            else {
                _this._error = message;
            }
            _this.transportService.loadTransports();
        });
    };
    AddTransportComponent.prototype.ngOnInit = function () {
    };
    AddTransportComponent.prototype.redirectToTransports = function () {
        this.router.navigateByUrl('/' + __WEBPACK_IMPORTED_MODULE_6__utils_route_list__["a" /* RouteList */].PAGE_TRANSPORT);
        this.transportComponent.ngOnInit();
    };
    Object.defineProperty(AddTransportComponent.prototype, "transportInfo", {
        get: function () {
            return this._transportInfo;
        },
        set: function (value) {
            this._transportInfo = value;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(AddTransportComponent.prototype, "error", {
        get: function () {
            return this._error;
        },
        set: function (value) {
            this._error = value;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(AddTransportComponent.prototype, "selectedTransportType", {
        get: function () {
            return this._selectedTransportType;
        },
        set: function (value) {
            this._selectedTransportType = value;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(AddTransportComponent.prototype, "availableTransportTypes", {
        get: function () {
            return this._availableTransportTypes;
        },
        set: function (value) {
            this._availableTransportTypes = value;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(AddTransportComponent.prototype, "selectedTransportFunctionality", {
        get: function () {
            return this._selectedTransportFunctionality;
        },
        set: function (value) {
            this._selectedTransportFunctionality = value;
        },
        enumerable: true,
        configurable: true
    });
    AddTransportComponent.prototype.setTransportType = function () {
        switch (this._selectedTransportType) {
            case __WEBPACK_IMPORTED_MODULE_2__service_transport_service_transport_service__["a" /* TransportService */].TRANSPORT_TYPE_TRAM: {
                this._transportInfo.transportType = __WEBPACK_IMPORTED_MODULE_2__service_transport_service_transport_service__["a" /* TransportService */].TRANSPORT_TYPE_TRAM;
                break;
            }
            case __WEBPACK_IMPORTED_MODULE_2__service_transport_service_transport_service__["a" /* TransportService */].TRANSPORT_TYPE_TROLLEYBUS: {
                this._transportInfo.transportType = __WEBPACK_IMPORTED_MODULE_2__service_transport_service_transport_service__["a" /* TransportService */].TRANSPORT_TYPE_TROLLEYBUS;
                break;
            }
            case __WEBPACK_IMPORTED_MODULE_2__service_transport_service_transport_service__["a" /* TransportService */].TRANSPORT_TYPE_BUS: {
                this._transportInfo.transportType = __WEBPACK_IMPORTED_MODULE_2__service_transport_service_transport_service__["a" /* TransportService */].TRANSPORT_TYPE_BUS;
                break;
            }
        }
    };
    AddTransportComponent.prototype.setTransportFunctionality = function () {
        switch (this._selectedTransportFunctionality) {
            case __WEBPACK_IMPORTED_MODULE_2__service_transport_service_transport_service__["a" /* TransportService */].TRANSPORT_FUNCTIONALITY_BROKEN: {
                this._transportInfo.noFunctionally = true;
                break;
            }
            default: {
                this._transportInfo.noFunctionally = false;
                ;
                break;
            }
        }
    };
    AddTransportComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-add-transport',
            template: __webpack_require__("../../../../../src/component/pages/transport/add-transport/add-transport.component.html"),
            styles: [__webpack_require__("../../../../../src/component/pages/transport/add-transport/add-transport.component.css")],
            providers: [__WEBPACK_IMPORTED_MODULE_1__service_transport_service_transport_data_source__["a" /* TransportDataSource */], __WEBPACK_IMPORTED_MODULE_2__service_transport_service_transport_service__["a" /* TransportService */]]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_2__service_transport_service_transport_service__["a" /* TransportService */], __WEBPACK_IMPORTED_MODULE_5__angular_router__["a" /* Router */], __WEBPACK_IMPORTED_MODULE_8__transport_component__["a" /* TransportComponent */]])
    ], AddTransportComponent);
    return AddTransportComponent;
}(__WEBPACK_IMPORTED_MODULE_3__page_component__["a" /* PageComponent */]));



/***/ }),

/***/ "../../../../../src/component/pages/transport/transport.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "\r\n.mat-icon-button{\r\n  position: fixed;\r\n  right: 5%;\r\n  bottom: 5%;\r\n}\r\n\r\n.add-transport-button-position {\r\n  position: absolute;\r\n  float: right;\r\n  z-index: 10;\r\n}\r\n\r\n.form-point {\r\n  position: absolute;\r\n  height:350px;\r\n  width: -webkit-max-content;\r\n  width: -moz-max-content;\r\n  width: max-content;\r\n  -ms-flex-item-align: center;\r\n      -ms-grid-row-align: center;\r\n      align-self: center;\r\n  margin-top: 10%;\r\n  margin-left: 30%;\r\n}\r\n\r\n.point-content {\r\n  position: absolute;\r\n  width: 81.5%;\r\n  color: #636363;\r\n  font-family: inherit;\r\n}\r\n\r\n.material-icons.blue{\r\n  color: #3f51b5;\r\n  font-size: 48px;\r\n}\r\n.material-icons.grey{\r\n  color: lightgrey;\r\n}\r\n\r\n.material-icons-text{\r\n  font-size: 10px;\r\n  font-weight: bold;\r\n  color: #3f51b5;\r\n}\r\n\r\n.mat-icon-button {\r\n  position: fixed;\r\n  right: 5%;\r\n  bottom: 5%;\r\n}\r\n.search-button {\r\n  display: -webkit-box;\r\n  display: -ms-flexbox;\r\n  display: flex;\r\n  -webkit-box-orient: horizontal;\r\n  -webkit-box-direction: reverse;\r\n      -ms-flex-direction: row-reverse;\r\n          flex-direction: row-reverse;\r\n}\r\n.add-point-button-position {\r\n  position: absolute;\r\n  float: right;\r\n  z-index: 10;\r\n}\r\n\r\n.card {\r\n  float: left;\r\n  margin: 10px;\r\n  position: relative;\r\n  width: 100px;\r\n}\r\n.mat-raised-button{\r\n  margin-top: 2%;\r\n  margin-left: 2%;\r\n  width: -webkit-max-content;\r\n  width: -moz-max-content;\r\n  width: max-content;\r\n}\r\n\r\n.mat-card-actions {\r\n  display: -webkit-box;\r\n  display: -ms-flexbox;\r\n  display: flex;\r\n  -webkit-box-orient: horizontal;\r\n  -webkit-box-direction: reverse;\r\n      -ms-flex-direction: row-reverse;\r\n          flex-direction: row-reverse;\r\n}\r\n.mat-card-content{\r\n  font-family: Roboto, \"Helvetica Neue\", sans-serif;\r\n  font-size: medium;\r\n  font-weight: bold;\r\n  color: #3f51b5;\r\n  text-align: center;\r\n}\r\n\r\n.mat-icon-button-card-actions {\r\n  position: relative;\r\n}\r\n.mat-icon-button-card-actions:hover {\r\n  color: red;\r\n}\r\n.sort-container{\r\n  margin-top: 2%;\r\n  position: relative;\r\n  display: -webkit-box;\r\n  display: -ms-flexbox;\r\n  display: flex;\r\n  -webkit-box-orient: horizontal;\r\n  -webkit-box-direction: normal;\r\n      -ms-flex-direction: row;\r\n          flex-direction: row;\r\n  width: -webkit-max-content;\r\n  width: -moz-max-content;\r\n  width: max-content;\r\n  height: inherit;\r\n}\r\n\r\n.form-delete-transport{\r\n  position: page;\r\n  font-family: Roboto, \"Helvetica Neue\", sans-serif;\r\n  font-size: medium;\r\n  font-weight: bold;\r\n  color: #3f51b5;\r\n  text-align: center;\r\n  border-collapse: collapse;\r\n  border-radius: 2px;\r\n  border-spacing: 0px;\r\n  padding: 10px;\r\n  background-color: white;\r\n}\r\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/component/pages/transport/transport.component.html":
/***/ (function(module, exports) {

module.exports = "<div>\r\n  <div class=\"sort-container\">\r\n    <button mat-button mat-raised-button color=\"primary\">\r\n      All transport\r\n    </button>\r\n    <button mat-button mat-raised-button color=\"primary\">\r\n      Buses\r\n    </button>\r\n    <button mat-button mat-raised-button color=\"primary\">\r\n      Trams\r\n    </button>\r\n    <button mat-button mat-raised-button color=\"primary\">\r\n      Trolleybuses\r\n    </button>\r\n  </div>\r\n\r\n\r\n  <div class=\"points\">\r\n    <div *ngFor=\"let transport of transports\">\r\n      <mat-card class=\"card\">\r\n        <mat-card-header>\r\n          <mat-card-title></mat-card-title>\r\n          <mat-card-subtitle></mat-card-subtitle>\r\n        </mat-card-header>\r\n\r\n        <img src=\"../../../assets/ic_directions_bus_black_24dp_2x.png\"/>\r\n\r\n        <mat-card-content>\r\n          <p> {{transport.transportType}}</p>\r\n          <p>{{transport.registrationNumber}}</p>\r\n          <mat-checkbox *ngIf=\"transport.noFunctionally == true\" [checked]=\"true\" color=\"primary\"> Is functional\r\n          </mat-checkbox>\r\n        </mat-card-content>\r\n        <mat-card-actions>\r\n\r\n          <button mat-icon-button class=\"mat-icon-button-card-actions\">\r\n            <mat-icon><i class=\"material-icons md-24 grey\" aria-hidden=\"true\"\r\n                         (click)=\"onDeleteSelect(transport)\">delete</i></mat-icon>\r\n          </button>\r\n\r\n          <button mat-icon-button class=\"mat-icon-button-card-actions\">\r\n            <mat-icon><i class=\"material-icons md-24 grey\" aria-hidden=\"true\"\r\n                         (click)=\"onEditSelect(transport)\">mode_edit</i></mat-icon>\r\n          </button>\r\n\r\n        </mat-card-actions>\r\n      </mat-card>\r\n    </div>\r\n  </div>\r\n\r\n  <div *ngIf=\"editSelectedTransport\">\r\n\r\n    <h2> DETAILS: {{ editSelectedTransport.registrationNumber | uppercase }} </h2>\r\n\r\n    <div>\r\n      <mat-input-container>\r\n        <mat-select placeholder=\"Transport functionality\" [(ngModel)]=\"selectedTransportFunctionality\" required\r\n                    true name=\"functionality\">\r\n          <mat-option *ngFor=\"let functionality of _availableTransportFunctionality\" [value]=\"functionality.value\">\r\n            {{ functionality.viewValue }}\r\n          </mat-option>\r\n        </mat-select>\r\n      </mat-input-container>\r\n    </div>\r\n    <div>\r\n      <mat-input-container class=\"add-point-data-row\">\r\n        <input matInput placeholder=\"Transport register number\" id=\"registrationNumber\" required\r\n               minlength=\"{{minRegisterNumber}}\"\r\n               maxlength=\"{{maxRegisterNumber}}\"\r\n               [(ngModel)]=\"transportInfo.registrationNumber\" name=\"registrationNumber\"\r\n               #name=\"ngModel\">\r\n      </mat-input-container>\r\n    </div>\r\n\r\n    <div>\r\n      <label>Registration Number:\r\n        <input placeholder=\"Registration Number\" [(ngModel)]=\"editSelectedTransport.registrationNumber \">\r\n      </label>\r\n    </div>\r\n    <mat-input-container>\r\n      <mat-select placeholder=\"Transport type\" [formControl]=\"transportTypeControl\" required\r\n                  [(ngModel)]=\"selectedTransportType\" name=\"transportType\">\r\n        <mat-option *ngFor=\"let transportType of availableTransportTypes\" [value]=\"transportType.value\">\r\n          {{ transportType.viewValue }}\r\n        </mat-option>\r\n      </mat-select>\r\n    </mat-input-container>\r\n\r\n    <div class=\"add-point-buttons\">\r\n      <button class=\"add-point-button\" type=\"submit\" mat-raised-button color=\"primary\"\r\n              [disabled]=\"!createForm.form.valid\" (click)=\"tryUpdateTransport()\"> Update transport\r\n      </button>\r\n      <button class=\"add-point-button\" type=\"submit\" mat-raised-button color=\"primary\"\r\n              (click)=\"redirectToTransports()\"> Cancel\r\n      </button>\r\n    </div>\r\n  </div>\r\n\r\n  <div class = \"form-delete-transport\" *ngIf=\"deleteSelectedTransport\">\r\n\r\n    <h2>DELETE{{ deleteSelectedTransport.registrationNumber | uppercase }} </h2>\r\n\r\n    <p> Are you sure to delete this transport?</p>\r\n    <div class=\"add-point-buttons\">\r\n      <button class=\"add-point-button\" type=\"submit\" mat-raised-button color=\"primary\"\r\n              (click)=\"tryDeleteTransport()\"> Delete transport\r\n      </button>\r\n      <button class=\"add-point-button\" type=\"submit\" mat-raised-button color=\"primary\"\r\n              (click)=\"redirectToTransports()\"> Cancel\r\n      </button>\r\n    </div>\r\n  </div>\r\n\r\n  <div>\r\n    <div class=\"mat-icon-button\" matTooltip=\"Add transport\">\r\n      <button mat-icon-button [routerLink]=\"['./add'] \">\r\n        <mat-icon><i class=\"material-icons md-48 blue\" aria-hidden=\"true\">add_circle</i></mat-icon>\r\n      </button>\r\n    </div>\r\n  </div>\r\n\r\n\r\n  <div class=\"form-point\">\r\n    <router-outlet></router-outlet>\r\n  </div>\r\n\r\n</div>\r\n"

/***/ }),

/***/ "../../../../../src/component/pages/transport/transport.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return TransportComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__page_component__ = __webpack_require__("../../../../../src/component/page.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__service_transport_service_transport_data_source__ = __webpack_require__("../../../../../src/service/transport-service/transport-data-source.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__service_transport_service_transport_service__ = __webpack_require__("../../../../../src/service/transport-service/transport.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_forms__ = __webpack_require__("../../../forms/esm5/forms.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__utils_route_list__ = __webpack_require__("../../../../../src/utils/route-list.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};







var TransportComponent = (function (_super) {
    __extends(TransportComponent, _super);
    function TransportComponent(transportService, router) {
        var _this = _super.call(this) || this;
        _this.transportService = transportService;
        _this.router = router;
        _this.transportTypeControl = new __WEBPACK_IMPORTED_MODULE_4__angular_forms__["b" /* FormControl */]('', [__WEBPACK_IMPORTED_MODULE_4__angular_forms__["j" /* Validators */].required]);
        _this.loadTransports();
        return _this;
    }
    TransportComponent.prototype.ngOnInit = function () {
        this.loadTransports();
    };
    TransportComponent.prototype.loadTransports = function () {
        var _this = this;
        this.transportService.loadTransports()
            .then(function (value) { return _this._transports = value; });
    };
    TransportComponent.prototype.onEditSelect = function (transport) {
        this._editSelectedTransport = transport;
        this._transportInfo = this._editSelectedTransport;
        this._error = '';
    };
    TransportComponent.prototype.onDeleteSelect = function (transport) {
        this._deleteSelectedTransport = transport;
        this._transportInfo = this._deleteSelectedTransport;
        this._error = '';
    };
    Object.defineProperty(TransportComponent.prototype, "selectedTransportType", {
        get: function () {
            return this._selectedTransportType;
        },
        set: function (value) {
            this._selectedTransportType = value;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(TransportComponent.prototype, "selectedTransportFunctionality", {
        get: function () {
            return this._selectedTransportFunctionality;
        },
        set: function (value) {
            this._selectedTransportFunctionality = value;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(TransportComponent.prototype, "editSelectedTransport", {
        get: function () {
            return this._editSelectedTransport;
        },
        set: function (value) {
            this._editSelectedTransport = value;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(TransportComponent.prototype, "deleteSelectedTransport", {
        get: function () {
            return this._deleteSelectedTransport;
        },
        set: function (value) {
            this._deleteSelectedTransport = value;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(TransportComponent.prototype, "transports", {
        get: function () {
            return this._transports;
        },
        set: function (value) {
            this._transports = value;
        },
        enumerable: true,
        configurable: true
    });
    TransportComponent.prototype.setTransportType = function () {
        switch (this._selectedTransportType) {
            case __WEBPACK_IMPORTED_MODULE_3__service_transport_service_transport_service__["a" /* TransportService */].TRANSPORT_TYPE_TRAM: {
                this._transportInfo.transportType = __WEBPACK_IMPORTED_MODULE_3__service_transport_service_transport_service__["a" /* TransportService */].TRANSPORT_TYPE_TRAM;
                break;
            }
            case __WEBPACK_IMPORTED_MODULE_3__service_transport_service_transport_service__["a" /* TransportService */].TRANSPORT_TYPE_TROLLEYBUS: {
                this._transportInfo.transportType = __WEBPACK_IMPORTED_MODULE_3__service_transport_service_transport_service__["a" /* TransportService */].TRANSPORT_TYPE_TROLLEYBUS;
                break;
            }
            case __WEBPACK_IMPORTED_MODULE_3__service_transport_service_transport_service__["a" /* TransportService */].TRANSPORT_TYPE_BUS: {
                this._transportInfo.transportType = __WEBPACK_IMPORTED_MODULE_3__service_transport_service_transport_service__["a" /* TransportService */].TRANSPORT_TYPE_BUS;
                break;
            }
        }
    };
    TransportComponent.prototype.setTransportFunctionality = function () {
        switch (this._selectedTransportFunctionality) {
            case __WEBPACK_IMPORTED_MODULE_3__service_transport_service_transport_service__["a" /* TransportService */].TRANSPORT_FUNCTIONALITY_BROKEN: {
                this._transportInfo.noFunctionally = true;
                break;
            }
            default: {
                this._transportInfo.noFunctionally = false;
                ;
                break;
            }
        }
    };
    TransportComponent.prototype.tryUpdateTransport = function () {
        var _this = this;
        this.setTransportType();
        this.setTransportFunctionality();
        this.transportService.updateTransport(this._transportInfo, function (message, result) {
            if (result) {
                _this.transportService.loadTransports();
                _this.redirectToTransports();
            }
            else {
                _this._error = message;
            }
            _this.transportService.loadTransports();
        });
    };
    TransportComponent.prototype.redirectToTransports = function () {
        this.router.navigateByUrl('/' + __WEBPACK_IMPORTED_MODULE_5__utils_route_list__["a" /* RouteList */].PAGE_TRANSPORT);
        this.ngOnInit();
    };
    TransportComponent.prototype.tryDeleteTransport = function () {
        var _this = this;
        this.transportService.deleteTransport(this._transportInfo, function (message, result) {
            if (result) {
                _this.transportService.loadTransports();
                _this.redirectToTransports();
            }
            else {
                _this._error = message;
            }
            _this.transportService.loadTransports();
        });
    };
    TransportComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-transport',
            template: __webpack_require__("../../../../../src/component/pages/transport/transport.component.html"),
            styles: [__webpack_require__("../../../../../src/component/pages/transport/transport.component.css")],
            encapsulation: __WEBPACK_IMPORTED_MODULE_0__angular_core__["_14" /* ViewEncapsulation */].Emulated,
            preserveWhitespaces: true,
            providers: [__WEBPACK_IMPORTED_MODULE_2__service_transport_service_transport_data_source__["a" /* TransportDataSource */]]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_3__service_transport_service_transport_service__["a" /* TransportService */], __WEBPACK_IMPORTED_MODULE_6__angular_router__["a" /* Router */]])
    ], TransportComponent);
    return TransportComponent;
}(__WEBPACK_IMPORTED_MODULE_1__page_component__["a" /* PageComponent */]));



/***/ }),

/***/ "../../../../../src/environments/environment.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return environment; });
// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `.angular-cli.json`.
var environment = {
    production: false
};


/***/ }),

/***/ "../../../../../src/main.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__ = __webpack_require__("../../../platform-browser-dynamic/esm5/platform-browser-dynamic.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__app_module__ = __webpack_require__("../../../../../src/app.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__environments_environment__ = __webpack_require__("../../../../../src/environments/environment.ts");




if (__WEBPACK_IMPORTED_MODULE_3__environments_environment__["a" /* environment */].production) {
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_17" /* enableProdMode */])();
}
Object(__WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__["a" /* platformBrowserDynamic */])().bootstrapModule(__WEBPACK_IMPORTED_MODULE_2__app_module__["a" /* AppModule */])
    .catch(function (err) { return console.log(err); });


/***/ }),

/***/ "../../../../../src/model/point/point-params.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return PointParams; });
var PointParams = (function () {
    function PointParams(name) {
        this.name = name;
    }
    return PointParams;
}());



/***/ }),

/***/ "../../../../../src/model/transport/transport-params.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return TransportParams; });
var TransportParams = (function () {
    function TransportParams(transportType, registrationNumber, noFunctionally) {
        this.transportType = transportType;
        this.registrationNumber = registrationNumber;
        this.noFunctionally = noFunctionally;
    }
    return TransportParams;
}());



/***/ }),

/***/ "../../../../../src/model/user/user-credentials.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return UserCredentials; });
var UserCredentials = (function () {
    function UserCredentials(login, password) {
        this.login = login;
        this.password = password;
    }
    return UserCredentials;
}());



/***/ }),

/***/ "../../../../../src/model/user/user.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return User; });
var User = (function () {
    function User(name, role, accessToken) {
        this._name = name;
        this._role = role;
        this._accessToken = accessToken;
    }
    Object.defineProperty(User.prototype, "name", {
        get: function () {
            return this._name;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(User.prototype, "role", {
        get: function () {
            return this._role;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(User.prototype, "accessToken", {
        get: function () {
            return this._accessToken;
        },
        enumerable: true,
        configurable: true
    });
    return User;
}());



/***/ }),

/***/ "../../../../../src/service/point-service/point-data-source.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return PointDataSource; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_rxjs_BehaviorSubject__ = __webpack_require__("../../../../rxjs/_esm5/BehaviorSubject.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__point_service__ = __webpack_require__("../../../../../src/service/point-service/point.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_cdk_collections__ = __webpack_require__("../../../cdk/esm5/collections.es5.js");
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var PointDataSource = (function (_super) {
    __extends(PointDataSource, _super);
    function PointDataSource(pointService) {
        var _this = _super.call(this) || this;
        _this.pointService = pointService;
        var emptyArray = [];
        _this.points = new __WEBPACK_IMPORTED_MODULE_1_rxjs_BehaviorSubject__["a" /* BehaviorSubject */](emptyArray);
        return _this;
    }
    PointDataSource.prototype.ngOnInit = function () {
    };
    PointDataSource.prototype.refresh = function () {
        var _this = this;
        this.pointService.loadPoints().then(function (value) {
            _this.points.next(value);
        });
    };
    PointDataSource.prototype.connect = function () {
        return this.points;
    };
    PointDataSource.prototype.disconnect = function (collectionViewer) {
    };
    PointDataSource = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["C" /* Injectable */])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_2__point_service__["a" /* PointService */]])
    ], PointDataSource);
    return PointDataSource;
}(__WEBPACK_IMPORTED_MODULE_3__angular_cdk_collections__["a" /* DataSource */]));



/***/ }),

/***/ "../../../../../src/service/point-service/point.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return PointService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__security_service_security_service__ = __webpack_require__("../../../../../src/service/security-service/security.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_http__ = __webpack_require__("../../../http/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__utils_utils__ = __webpack_require__("../../../../../src/utils/utils.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var PointService = (function () {
    function PointService(http, security) {
        this.http = http;
        this.security = security;
    }
    PointService_1 = PointService;
    PointService.prototype.loadPoints = function () {
        return this.http.get(PointService_1.PAGE_POINTS_URL)
            .toPromise()
            .then(function (response) {
            var body = response.json();
            return body;
        })
            .catch(this.hadnlerError);
    };
    PointService.prototype.hadnlerError = function (error) {
        return Promise.reject(error.message || error);
    };
    PointService.prototype.createPoint = function (params, handler) {
        this.http.post(PointService_1.PAGE_POINTS_URL, params)
            .toPromise()
            .then(function (response) { return handler(null, true); })
            .catch(function (error) { return __WEBPACK_IMPORTED_MODULE_3__utils_utils__["a" /* Utils */].handleErrorMessageJson(error, function (ex) { return handler(ex, false); }); });
    };
    PointService.prototype.deletePoint = function (point, handler) {
        this.http.delete(PointService_1.PAGE_POINTS_URL + '/' + point.id).toPromise().then(function (response) { return handler(null, true); })
            .catch(function (error) { return __WEBPACK_IMPORTED_MODULE_3__utils_utils__["a" /* Utils */].handleErrorMessageJson(error, function (ex) { return handler(ex, false); }); });
    };
    PointService.prototype.updatePoint = function (point, handler) {
        this.http.put(PointService_1.PAGE_POINTS_URL + '/' + point.id, point).toPromise().then(function (response) { return handler(null, true); })
            .catch(function (error) { return __WEBPACK_IMPORTED_MODULE_3__utils_utils__["a" /* Utils */].handleErrorMessageJson(error, function (ex) { return handler(ex, false); }); });
    };
    PointService.PAGE_POINTS_URL = '/api/points';
    PointService = PointService_1 = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["C" /* Injectable */])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_2__angular_http__["a" /* Http */], __WEBPACK_IMPORTED_MODULE_1__security_service_security_service__["a" /* SecurityService */]])
    ], PointService);
    return PointService;
    var PointService_1;
}());



/***/ }),

/***/ "../../../../../src/service/security-service/security.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SecurityService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_http__ = __webpack_require__("../../../http/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_rxjs_BehaviorSubject__ = __webpack_require__("../../../../rxjs/_esm5/BehaviorSubject.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_toPromise__ = __webpack_require__("../../../../rxjs/_esm5/add/operator/toPromise.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_toPromise___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_toPromise__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__utils_utils__ = __webpack_require__("../../../../../src/utils/utils.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__model_user_user__ = __webpack_require__("../../../../../src/model/user/user.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};






var SecurityService = (function () {
    function SecurityService(http) {
        this.http = http;
        this._authProperty = new __WEBPACK_IMPORTED_MODULE_2_rxjs_BehaviorSubject__["a" /* BehaviorSubject */](false);
    }
    SecurityService_1 = SecurityService;
    /**
     * The function to auth a user in the system.
     *
     * @param credentials the credentials.
     * @param handler to handle result of authentication.
     */
    SecurityService.prototype.auth = function (credentials, handler) {
        var _this = this;
        var username = credentials.login;
        this.http.post(SecurityService_1.AUTH_URL, credentials)
            .toPromise()
            .then(function (response) {
            var body = response.json();
            _this._user = new __WEBPACK_IMPORTED_MODULE_5__model_user_user__["a" /* User */](username, body.token, body.role);
            _this._authProperty.next(true);
            handler(null, true);
        })
            .catch(function (error) { return __WEBPACK_IMPORTED_MODULE_4__utils_utils__["a" /* Utils */].handleErrorMessage(error, function (ex) { return handler(ex, false); }); });
    };
    /**
     * Add an access token to header of the request options.
     *
     * @param requestOptions the request options.
     */
    SecurityService.prototype.addAccessToken = function (requestOptions) {
        var accessToken = this.accessToken;
        if (accessToken != null) {
            requestOptions.headers.append(SecurityService_1.ACCESS_TOKEN_HEADER, accessToken);
        }
    };
    /**
     * The function to logout from the system.
     */
    SecurityService.prototype.logout = function () {
        this._user = null;
        this._authProperty.next(false);
    };
    Object.defineProperty(SecurityService.prototype, "authProperty", {
        /**
         * Get the auth property.
         *
         * @returns {Observable<boolean>} the auth property.
         */
        get: function () {
            return this._authProperty;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(SecurityService.prototype, "user", {
        /**
         * Get the current user.
         *
         * @returns {User} the current user.
         */
        get: function () {
            return this._user;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(SecurityService.prototype, "accessToken", {
        /**
         * Get the current access token.
         *
         * @returns {string} the current access token.
         */
        get: function () {
            var currentUser = this._user;
            if (currentUser == null) {
                return null;
            }
            return currentUser.accessToken;
        },
        enumerable: true,
        configurable: true
    });
    /**
     * Check the role in the current user.
     *
     * @param {string} toCheck the role to check.
     * @returns {boolean} true if the current user has the role.
     */
    SecurityService.prototype.hasRole = function (toCheck) {
        var currentUser = this._user;
        if (currentUser == null) {
            return false;
        }
        var role = currentUser.role;
        if (role === toCheck) {
            return true;
        }
        return false;
    };
    SecurityService.ROLE_ADMIN = 'ADMIN';
    SecurityService.ROLE_USER = 'USER';
    /**
     * The url of auth endpoint.
     *
     * @type {string}
     */
    SecurityService.AUTH_URL = '/?/authenticate';
    /**
     * The name of access token header.
     *
     * @type {string}
     */
    SecurityService.ACCESS_TOKEN_HEADER = 'X-Access-Token';
    SecurityService = SecurityService_1 = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["C" /* Injectable */])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__angular_http__["a" /* Http */]])
    ], SecurityService);
    return SecurityService;
    var SecurityService_1;
}());



/***/ }),

/***/ "../../../../../src/service/transport-service/transport-data-source.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return TransportDataSource; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_cdk_collections__ = __webpack_require__("../../../cdk/esm5/collections.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_rxjs_BehaviorSubject__ = __webpack_require__("../../../../rxjs/_esm5/BehaviorSubject.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__transport_service__ = __webpack_require__("../../../../../src/service/transport-service/transport.service.ts");
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var TransportDataSource = (function (_super) {
    __extends(TransportDataSource, _super);
    function TransportDataSource(transportService) {
        var _this = _super.call(this) || this;
        _this.transportService = transportService;
        var emptyArray = [];
        _this.transports = new __WEBPACK_IMPORTED_MODULE_2_rxjs_BehaviorSubject__["a" /* BehaviorSubject */](emptyArray);
        return _this;
    }
    TransportDataSource.prototype.ngOnInit = function () {
    };
    TransportDataSource.prototype.refresh = function () {
        var _this = this;
        this.transportService.loadTransports().then(function (value) {
            _this.transports.next(value);
        });
    };
    TransportDataSource.prototype.connect = function () {
        return this.transports;
    };
    TransportDataSource.prototype.disconnect = function (collectionViewer) {
    };
    TransportDataSource = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["C" /* Injectable */])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_3__transport_service__["a" /* TransportService */]])
    ], TransportDataSource);
    return TransportDataSource;
}(__WEBPACK_IMPORTED_MODULE_1__angular_cdk_collections__["a" /* DataSource */]));



/***/ }),

/***/ "../../../../../src/service/transport-service/transport.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return TransportService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_http__ = __webpack_require__("../../../http/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__security_service_security_service__ = __webpack_require__("../../../../../src/service/security-service/security.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__utils_utils__ = __webpack_require__("../../../../../src/utils/utils.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var TransportService = (function () {
    function TransportService(http, security) {
        this.http = http;
        this.security = security;
    }
    TransportService_1 = TransportService;
    TransportService.prototype.loadTransports = function () {
        return this.http.get(TransportService_1.TRANSPORTS_URL)
            .toPromise().then(function (response) {
            var body = response.json();
            return body;
        })
            .catch(this.hadnlerError);
    };
    TransportService.prototype.hadnlerError = function (error) {
        return Promise.reject(error.message || error);
    };
    TransportService.prototype.createTransport = function (params, handler) {
        this.http.post(TransportService_1.TRANSPORTS_URL, params)
            .toPromise()
            .then(function (response) { return handler(null, true); })
            .catch(function (error) { return __WEBPACK_IMPORTED_MODULE_3__utils_utils__["a" /* Utils */].handleErrorMessageJson(error, function (ex) { return handler(ex, false); }); });
    };
    TransportService.prototype.updateTransport = function (transport, handler) {
        this.http.put(TransportService_1.TRANSPORTS_URL + '/' + transport.id, transport)
            .toPromise()
            .then(function (response) { return handler(null, true); })
            .catch(function (error) { return __WEBPACK_IMPORTED_MODULE_3__utils_utils__["a" /* Utils */].handleErrorMessageJson(error, function (ex) { return handler(ex, false); }); });
    };
    TransportService.prototype.deleteTransport = function (transport, handler) {
        this.http.delete(TransportService_1.TRANSPORTS_URL + '/' + transport.id).toPromise().then(function (response) { return handler(null, true); })
            .catch(function (error) { return __WEBPACK_IMPORTED_MODULE_3__utils_utils__["a" /* Utils */].handleErrorMessageJson(error, function (ex) { return handler(ex, false); }); });
    };
    TransportService.TRANSPORTS_URL = '/api/transports';
    TransportService.TRANSPORT_TYPE_BUS = "BUS";
    TransportService.TRANSPORT_TYPE_TRAM = "TRAM";
    TransportService.TRANSPORT_TYPE_TROLLEYBUS = "TROLLEYBUS";
    TransportService.TRANSPORT_FUNCTIONALITY_BROKEN = "BROKEN";
    TransportService.TRANSPORT_FUNCTIONALITY_WORKING = "WORKING";
    TransportService = TransportService_1 = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["C" /* Injectable */])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__angular_http__["a" /* Http */], __WEBPACK_IMPORTED_MODULE_2__security_service_security_service__["a" /* SecurityService */]])
    ], TransportService);
    return TransportService;
    var TransportService_1;
}());



/***/ }),

/***/ "../../../../../src/utils/route-list.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return RouteList; });
var RouteList = (function () {
    function RouteList() {
    }
    RouteList.PAGE_LOGIN = 'login';
    RouteList.PAGE_SCHEDULE = 'schedule';
    RouteList.PAGE_POINT = 'point';
    RouteList.PAGE_TRANSPORT = 'transport';
    RouteList.PAGE_ROUTE = 'route';
    RouteList.PAGE_ADD_POINT = 'add';
    RouteList.PAGE_ADD_TRANSPORT = 'add';
    return RouteList;
}());



/***/ }),

/***/ "../../../../../src/utils/utils.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return Utils; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_http__ = __webpack_require__("../../../http/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_rxjs_Observable__ = __webpack_require__("../../../../rxjs/_esm5/Observable.js");


var Utils = (function () {
    function Utils() {
    }
    /**
     * The method to handle an error from http request.
     *
     * @param error the error.
     * @param handler the error message consumer.
     * @returns {ErrorObservable}
     */
    Utils.handleErrorMessage = function (error, handler) {
        var errMsg;
        if (error instanceof __WEBPACK_IMPORTED_MODULE_0__angular_http__["c" /* Response */]) {
            errMsg = error.text();
        }
        else {
            errMsg = error.message ? error.message : error.toString();
        }
        console.error(errMsg);
        handler(errMsg);
        return __WEBPACK_IMPORTED_MODULE_1_rxjs_Observable__["a" /* Observable */].throw(errMsg);
    };
    /**
     * The method to handle an error from http request.
     *
     * @param error the error from the Json obj.
     * @param handler the error message consumer.
     * @returns {ErrorObservable}
     */
    Utils.handleErrorMessageJson = function (error, handler) {
        // In a real world app, you might use a remote logging infrastructure
        var errMsg;
        if (error instanceof __WEBPACK_IMPORTED_MODULE_0__angular_http__["c" /* Response */]) {
            var body = error.json();
            errMsg = body.message;
        }
        else {
            errMsg = error.message ? error.message : error.toString();
        }
        console.error(errMsg);
        handler(errMsg);
        return __WEBPACK_IMPORTED_MODULE_1_rxjs_Observable__["a" /* Observable */].throw(errMsg);
    };
    /**
     * The method to handle an error from http request.
     *
     * @param {Response | any} error the error.
     * @returns {Promise<never>} the error msg.
     */
    Utils.handleError = function (error) {
        console.error(error.message || error);
        return Promise.reject(error.message || error);
    };
    return Utils;
}());



/***/ }),

/***/ 0:
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__("../../../../../src/main.ts");


/***/ })

},[0]);
//# sourceMappingURL=main.bundle.js.map