from iconservice import *
import json


class ABCToken(IconScoreBase):

    __USER_ADDRESS = 'user_address'
    __ISSUERS = 'issuers'

    def __init__(self, db: IconScoreDatabase) -> None:
        super().__init__(db)

        self.__users_address = DictDB(self.__USER_ADDRESS, db, value_type=str, depth=1) # default = 1
        self.__issuers = DictDB(self.__ISSUERS, db, value_type=str, depth=1) # default = 1

    def on_install(self) -> None:
        super().on_install()

    def on_update(self) -> None:
        super().on_update()
    
    @external(readonly=True)
    def get_my_claims(self) -> str:
        claims = self.__get_array_of(str(self.msg.sender))
        result = []
        for e in claims:
            result.append(e)

        print(json.dumps(result))
        return json.dumps(result)

    @external
    def add_claim(self, claim: str):
        print(self.__get_array_of(str(self.msg.sender)).put(claim))

    def __get_array_of(self, address: str):
        return ArrayDB(address, self.db, value_type=str)

    @external
    def add_new_user(self, public_key: str) -> str:
        if self.__users_address[str(self.msg.sender)] == "": # not existed
            self.__users_address[str(self.msg.sender)] = public_key
            print("Add new user")
            return "OK"
        else:
            print("FAILED")
            return "FAILURE"

    @external
    def add_new_issuers(self, public_key: str) -> str:
        if self.__issuers[str(self.msg.sender)] == "": # not existed
            self.__issuers[str(self.msg.sender)] = public_key
            return "OK"
        else:
            return "FAILURE"

    @external(readonly=True)
    def get_user_public_key(self, user_address: str) -> str:
        key = self.__users_address[user_address]
        if str(key) == "":
            return "FAILURE"
        else:
            return str(key)

    @external(readonly=True)
    def get_issuer_public_key(self, issuer_address: str) -> str:
        key = self.__issuers[issuer_address]
        if str(key) == "":
            return "FAILURE"
        else:
            return str(key)


