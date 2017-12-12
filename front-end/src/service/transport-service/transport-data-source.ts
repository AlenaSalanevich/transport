import {Injectable} from "@angular/core";
import {DataSource} from "@angular/cdk/collections";
import {TransportEntity} from "../../model/transport/transport-entity";
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {TransportService} from "./transport.service";
import {Observable} from "rxjs/Observable";

@Injectable()
export class TransportDataSource extends DataSource<TransportEntity>{

private transports: BehaviorSubject<TransportEntity[]>;
constructor (private readonly transportService: TransportService){
  super();
  let emptyArray: TransportEntity[]=[];
  this.transports=new BehaviorSubject(emptyArray);
}

  ngOnInit() {
}
  public refresh(){
    this.transportService.loadTransports().then(value => {
      this.transports.next(value);
    })
  }

  connect(): Observable<TransportEntity[]>{
    return this.transports;
  }
  disconnect(){

  }
}

