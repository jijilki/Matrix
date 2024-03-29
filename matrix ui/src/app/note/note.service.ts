import { Note } from './note';
import { NoteFilter } from './note-filter';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { map } from 'rxjs/operators';

const headers = new HttpHeaders().set('Accept', 'application/json');

@Injectable()
export class NoteService {
  noteList: Note[] = [];
  api = 'http://localhost:8080/api/notes';

  constructor(private http: HttpClient) {
  }

  findById(id: string): Observable<Note> {
    const url = `${this.api}/${id}`;
    const params = { id: id };
    return this.http.get<Note>(url, {params, headers});
  }

  load(filter: NoteFilter): void {
    this.find(filter).subscribe(result => {
        this.noteList = result;
      },
      err => {
        console.error('error loading', err);
      }
    );
  }

  find(filter: NoteFilter): Observable<Note[]> {
    const params = {
      'title': filter.title,
    };

    return this.http.get<any>(this.api, {params, headers}).pipe(map(res => res._embedded.notes as Note[]));
  }

  save(entity: Note): Observable<Note> {
    let params = new HttpParams();
    let url = '';
    if (entity.id) {
      url = `${this.api}/${entity.id.toString()}`;
      params = new HttpParams().set('ID', entity.id.toString());
      return this.http.put<Note>(url, entity, {headers, params});
    } else {
      url = `${this.api}`;
      return this.http.post<Note>(url, entity, {headers, params});
    }
  }

  delete(entity: Note): Observable<Note> {
    let params = new HttpParams();
    let url = '';
    if (entity.id) {
      url = `${this.api}/${entity.id.toString()}`;
      params = new HttpParams().set('ID', entity.id.toString());
      return this.http.delete<Note>(url, {headers, params});
    }
    return new Observable;
  }
}

