export class UserCreationEvent {
    constructor(public id: string, public login: string, public date: Date) {}
}

//lepiej interaface