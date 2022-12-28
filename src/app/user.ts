import { HttpParams } from "@angular/common/http";

export class User {

     name:any;
timings:any;
     category:any;
  static category: HttpParams | { [param: string]: string | number | boolean | readonly (string | number | boolean)[]; } | undefined;
}
